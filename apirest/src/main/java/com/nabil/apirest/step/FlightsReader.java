package com.nabil.apirest.step;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nabil.apirest.pojo.FlightsResponse;

import lombok.extern.java.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Log
@Component
public class FlightsReader implements ItemReader<FlightsResponse> {

	@Autowired
	@Qualifier("flightsClient")
	OkHttpClient client;

	@Value("${flights.api.endpoint}")
	String flightEndpoint;
	@Value("${flights.days.interval}")
	Integer daysInterval;

	private Date date = new Date();
	private int count = 0;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public FlightsResponse read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		if (count < daysInterval) {

			String dateStr = getDateStr();
			log.info(dateStr);

			Request request = new Request.Builder()
					.url(flightEndpoint + "/apiservices/browsedates/v1.0/FR/EUR/fr-FR/CDG-sky/NYCA-sky/" + dateStr)
					.build();
			Response response = client.newCall(request).execute();
			FlightsResponse res = parseResponse(response);

			count++;
			return res;
		} else {
			count = 0;
		}
		return null;
	}

	private String getDateStr() {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, count);

		return sdf.format(c.getTime());
	}

	private FlightsResponse parseResponse(Response response)
			throws JsonMappingException, JsonProcessingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(response.body().string(), FlightsResponse.class);
	}
}