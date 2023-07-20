package com.example.Flightsinfosystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.Flightsinfosystem.entities.ScheduledFlight;
import com.example.Flightsinfosystem.repos.FlightRepo;
import com.example.Flightsinfosystem.repos.ScheduledFlightRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ScheduledFlightcontroller {
	@Autowired
	ScheduledFlightRepo sfr;
	@Autowired
	FlightRepo fr;

	// add Scheduled flight
	@PostMapping("/addscheduledflight")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary = "To scheduled a flight", description = "Enter flightno,deptdate,arrivaldate to schedule flight")
	public ScheduledFlight addflight(@RequestParam() int flightno, @RequestParam() LocalDate deptdate,
			@RequestParam() LocalDate arrivaldate) {
		var flight = fr.findById(flightno);
		if (flight.isPresent()) {
			ScheduledFlight s = sfr.findByFlightNoAndDeptDate(flightno, deptdate);
			if (s != null) {
				throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Flight is already Scheduled");
			} else {
				var f = flight.get();
				s = new ScheduledFlight(flightno, deptdate, f.getDepartureTime(), arrivaldate, f.getArrivalTime(),
						f.getDurationInMinutes(), f.getFrom_City(), f.getTo_City());
				sfr.save(s);
				return s;
			}

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
		}
	}

	// delete Scheduled flights for the given range of dates
	@DeleteMapping("/cancelscheduledflights")
	@PreAuthorize("hasRole('flightmanager')")
	@Operation(summary = "To cancel flights between dates", description = "Enter the fromdate and todate")
	public void cancelFlight(@RequestParam() LocalDate fromdate, @RequestParam() LocalDate todate, @RequestParam int flightNo) {
		var scflights = sfr.getscheduledflights(fromdate, todate,flightNo);
		if (scflights.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Flights Scheduled in the given date");
	
		} else {
			for (var scflight : scflights) {
				sfr.delete(scflight);
	
			}
		}
	}
	
	
	// list of scheduled flights
	@GetMapping("/scheduledflights")
	@Operation(summary = "To get the scheduled flights for the given city and deptdate", description = "Enter the deptdate and fromcity")
	public List<ScheduledFlight> sf(@RequestParam() LocalDate deptdate, @RequestParam() String fromcity) {
		return sfr.getFlights(deptdate, fromcity);
	}
}
