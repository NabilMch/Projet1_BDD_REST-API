package com.nabil.apirest.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nabil.apirest.entities.FlightsEntity;

@Repository
public interface FlightsRepository extends CrudRepository<FlightsEntity, Long> {

}
