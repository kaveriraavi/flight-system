package com.example.Flightsinfosystem.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Flightsinfosystem.entities.FlightDate;
import com.example.Flightsinfosystem.entities.FlightHistory;

public interface FlightHistoryRepo extends JpaRepository<FlightHistory,FlightDate> {
	
	// flight history by flight no
	//derived query
   List<FlightHistory> findByFlightNo(int flightno); 
   
   //list of delayed flights
    @Query("from FlightHistory fh INNER JOIN FETCH fh.fn f Where DATEDIFF(MINUTE,f.arrivalTime,fh.arrivalTime) =:minutes")
	List<FlightHistory> getDelayedFlights(@Param("minutes")int minutes);
}
