package com.nabil.apirest.step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nabil.apirest.entities.FlightsEntity;
import com.nabil.apirest.pojo.FlightsResponse;

import lombok.extern.java.Log;

@Log
@Component
public class FlightsProcessor implements ItemProcessor<FlightsResponse, FlightsEntity> {

	@Override
	public FlightsEntity process(FlightsResponse r) throws Exception {
		
		FlightsEntity e = new FlightsEntity();
		Double prix = r.getDates().getOutboundDates().get(0).getPrice();
		Date date = parseDate(r.getDates().getOutboundDates().get(0).getQuoteDateTime()); 
		String aeroportDepart = r.getPlaces().get(0).getName();
		String aeroportArrivee = r.getPlaces().get(1).getName();
		String paysDepart = r.getPlaces().get(0).getCountryName();
		String paysArrivee = r.getPlaces().get(1).getCountryName();
		String villeArrivee = r.getPlaces().get(1).getCityName();
		
		e.setPrixEuros(prix);
		e.setDate(date);
		e.setAeroportDepart(aeroportDepart);
		e.setAeroportArrivee(aeroportArrivee);
		e.setPaysDepart(paysDepart);
		e.setPaysArrivee(paysArrivee);
		e.setVilleArrivee(villeArrivee);
		return e;
	}

	
	private Date parseDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
}


