package com.example.Flightsinfosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flightsinfosystem.entities.FlightHistory;
import com.example.Flightsinfosystem.repos.FlightHistoryRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class FlightHistoryController {
	// dependency infection
	@Autowired
	FlightHistoryRepo fhr;

	// Flight by flight no
	@GetMapping("/getflightbyflightno/{flightno}")
	@Operation(summary = "Get flight history by flightno", description = "Enter the flightno")
	public List<FlightHistory> getFlightByFlightNo(@PathVariable("flightno") int flightno) {
		return fhr.findByFlightNo(flightno);
	}

	// DelayedFlights
	@GetMapping("delayedflights/{minutes}")
	@Operation(summary = "Get delayed flight list", description = "Enter the minutes to get all delayed flights")
	public List<FlightHistory> delayedFlights(@PathVariable("minutes") int minutes) {
		return fhr.getDelayedFlights(minutes);
	}
}
