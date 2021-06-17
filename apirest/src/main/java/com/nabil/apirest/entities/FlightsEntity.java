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
@Table(name="flights")
@Entity
public class FlightsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="aeroport_depart")
	String aeroportDepart;
	@Column(name="aeroport_arrivee")
	String aeroportArrivee;
	@Column(name="ville_arrivee")
	String villeArrivee;
	@Column(name="date_depart")
	Date date;
	@Column(name="prix_euros")
	Double prixEuros;
	@Column(name="pays_depart")
	String paysDepart;
	@Column(name="pays_arrivee")
	String paysArrivee;
	
}
