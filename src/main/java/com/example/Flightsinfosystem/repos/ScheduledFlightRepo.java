package com.example.Flightsinfosystem.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Flightsinfosystem.entities.FlightDate;
import com.example.Flightsinfosystem.entities.ScheduledFlight;

public interface ScheduledFlightRepo extends JpaRepository<ScheduledFlight,FlightDate> {

	// cancel scheduled flights for the given range
	@Query("from ScheduledFlight where deptDate>=:fromdate and deptDate<=:todate and flightNo=:flightNo")
	public List<ScheduledFlight> getscheduledflights(@Param("fromdate")LocalDate fromdate,
													@Param("todate")LocalDate todate,
													@Param("flightNo") int flightNo);
	
	//adding scheduled flight
		ScheduledFlight findByFlightNoAndDeptDate(int flightno,LocalDate deptdate);
		
		// 10 scheduled flights for a given date and city
		@Query("from ScheduledFlight where deptDate=:departuredate and fromCity.cityCode=:citycode")
		public List<ScheduledFlight> getFlights(@Param("departuredate")LocalDate deptdate,@Param("citycode")String fromcity);
	
	
}
