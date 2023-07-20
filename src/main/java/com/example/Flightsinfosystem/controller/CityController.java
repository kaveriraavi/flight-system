package com.example.Flightsinfosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Flightsinfosystem.entities.City;
import com.example.Flightsinfosystem.repos.CityRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CityController {

	// dependency injection
	@Autowired
	CityRepo cr;

	// List of cities

	@GetMapping("/getcities")
	@Operation(summary = "Get city list", description = "Can be accessed without any input")
	public List<City> getcities() {
		return cr.findAll();
	}

	// add a new city

	@PostMapping("/insert")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary = "Add City into cities table", description = "Give Complete City body")
	public City addcity(@RequestBody City city) {
		if (cr.findById(city.getCityCode()).isPresent())
			throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "City already exists");
		else {
			var c = cr.save(city);
			return c;

		}
	}

	// delete a city by city code
	@DeleteMapping("/deletecity{citycode}")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary = "Delete a city by citycode", description = "Give a valid city code")
	public String deletecity(@PathVariable() String citycode) {
		if (cr.findById(citycode).isPresent()) {
			cr.deleteById(citycode);
			return "Deleted Successfully";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No city found");
		}
	}

	// update the city

	@PutMapping("/updatecityinfo/{citycode}")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary="Update the city information",description ="Enter the city code in pathvariable to update")
	public City updatecityinfo(@PathVariable() String citycode, @RequestParam() String name,@RequestParam() int minutesfromutc,@RequestParam() String country) {
		var c = cr.findById(citycode);
		if (c.isPresent()) {
			var city = c.get();
			city.setMinutesFromUTC(minutesfromutc);
			city.setCountry(country);
			city.setName(name);
			cr.save(city); //saving changes in database
			return city;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
		}
	}

		//get minutes from city code
	
	@GetMapping("/getminutesfromutc/{citycode}")
	public City getminutes(@PathVariable() String citycode) {
		City m = cr.findById(citycode).get();
		return m;
	}
	
}
