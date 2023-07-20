package com.example.Flightsinfosystem.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Flightsinfosystem.entities.Flight;

public interface FlightRepo extends JpaRepository<Flight,Integer> {
	
	@Query("from Flight where fromCity.cityCode=:fromcity and toCity.cityCode=:tocity")
	List<Flight> getflightsbetweencities(@Param("fromcity")String fc,@Param("tocity")String tc);
	
	@Query("select flightNo from Flight where fromCity.cityCode=:fromcity")
	int getflightNo(@Param("fromcity")String fc);
	
}
