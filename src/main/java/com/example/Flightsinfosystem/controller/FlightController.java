package com.example.Flightsinfosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Flightsinfosystem.entities.Flight;
import com.example.Flightsinfosystem.repos.CityRepo;
import com.example.Flightsinfosystem.repos.FlightRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class FlightController {

	// dependency injection
	@Autowired
	CityRepo cr;
	@Autowired
	FlightRepo fr;

	// flights by pagination

	@GetMapping("/flights/{pagenum}")
	@Operation(summary = "Get flights by page num", description = "Enter pagenum to get the details")
	public List<Flight> getflights(@PathVariable("pagenum") int pagenum) {
		return fr.findAll(PageRequest.of(pagenum, 5)).getContent();
	}

	// flights from and to cities

	@GetMapping("/flightsbetweencities")
	@Operation(summary = "Get flights between cities", description = "Enter fromcity and tocity to get flight details")
	public List<Flight> flightbetweenCity(@RequestParam() String fromcity, @RequestParam() String tocity) {
		return fr.getflightsbetweencities(fromcity, tocity);
	}

	// add flight

	@PostMapping("/addflight")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary = "To add new flight", description = "Enter flight details")
	public Flight addflight(@RequestBody Flight f) {
		var fromcity = cr.findById(f.getFrom_City());
		var tocity = cr.findById(f.getTo_City());
		if (fromcity.isPresent() && tocity.isPresent()) {
			var af = fr.save(f);
			return af;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "city not found");
	}
	@GetMapping("/getflight/{fromcity}")
	public int getFlight(@PathVariable("fromcity")String fc) {
		int f= fr.getflightNo(fc);
		return f;
	}

}
