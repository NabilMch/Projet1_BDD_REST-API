package com.nabil.apirest.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nabil.apirest.entities.FlightsEntity;
import com.nabil.apirest.repos.FlightsRepository;

import lombok.extern.java.Log;

@Log
@Component
public class FlightsWriter implements ItemWriter<FlightsEntity> {

	@Autowired
	FlightsRepository flightsRepository;

	@Override
	public void write(List<? extends FlightsEntity> entities) throws Exception {
		for (FlightsEntity entity : entities) {
			log.info("saving: " + entity.toString() );
			flightsRepository.save(entity);
		}
	}

}