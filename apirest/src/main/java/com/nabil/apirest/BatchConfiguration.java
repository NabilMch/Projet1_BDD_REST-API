package com.nabil.apirest;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nabil.apirest.entities.FlightsEntity;
import com.nabil.apirest.pojo.FlightsResponse;
import com.nabil.apirest.repos.FlightsRepository;
import com.nabil.apirest.step.FlightsProcessor;
import com.nabil.apirest.step.FlightsReader;
import com.nabil.apirest.step.FlightsWriter;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	EntityManagerFactory emf;

	@Autowired
	FlightsReader flightsReader;

	@Autowired
	ItemWriter<? super FlightsEntity> flightsWriter;

	@Autowired
	ItemProcessor<? super FlightsResponse, ? extends FlightsEntity> flightsProcessor;

	@Bean
	public Job processJob() {
		return jobBuilderFactory
				.get("processJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.flow(flightsStep())
				.next(weatherStep())
				.end().build();
	}

	@Bean
	public Step flightsStep() {
		return stepBuilderFactory.get("flightsStep")
				.<FlightsResponse, FlightsEntity>chunk(1).reader(flightsReader)
				.processor(flightsProcessor)
				.writer(flightsWriter)
				.build();
	}

	// a modifier
	@Bean
	public Step weatherStep() {
		return stepBuilderFactory.get("weatherStep")
				.<FlightsResponse, FlightsEntity>chunk(1).reader(flightsReader)
				.processor(flightsProcessor)
				.writer(flightsWriter)
				.build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}
