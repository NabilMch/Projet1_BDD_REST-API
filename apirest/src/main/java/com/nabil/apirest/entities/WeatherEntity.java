package com.nabil.apirest.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="weathers")
@Entity
public class WeatherEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="date")
	Date date;
	@Column(name="ville")
	Double ville;
	@Column(name="condition")
	String condition;

}
