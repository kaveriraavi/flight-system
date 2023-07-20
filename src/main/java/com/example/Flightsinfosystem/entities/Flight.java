package com.example.Flightsinfosystem.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	@Id
	@Column(name = "flightno") // primary key
	private int flightNo;
	@Column(name = "fromcity")
	private String from_City;
	@Column(name = "tocity")
	private String to_City;
	@Column(name = "durationinminutes")
	private int durationInMinutes;
	@Column(name = "departuretime")
	private LocalTime departureTime;
	@Column(name = "arrivaltime")
	private LocalTime arrivalTime;
	private String aircraft;

	// mapping with city
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "fromcity", insertable = false, updatable = false)
	private City fromCity;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "tocity", insertable = false, updatable = false)
	private City toCity;

	// mapping with scheduled flight
	@OneToMany(mappedBy = "flight")
	@JsonIgnore
	private List<ScheduledFlight> flights = new ArrayList<>();

	// mapping with flight history
	@OneToMany(mappedBy = "fn")
	@JsonIgnore
	private List<FlightHistory> fh = new ArrayList<>();

	// Getters and Setters


	public int getFlightNo() {
		return flightNo;
	}

	public String getFrom_City() {
		return from_City;
	}

	public String getTo_City() {
		return to_City;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public String getAircraft() {
		return aircraft;
	}

	public City getFromCity() {
		return fromCity;
	}

	public City getToCity() {
		return toCity;
	}

	public List<ScheduledFlight> getFlights() {
		return flights;
	}

	public List<FlightHistory> getFh() {
		return fh;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public void setFrom_City(String from_City) {
		this.from_City = from_City;
	}

	public void setTo_City(String to_City) {
		this.to_City = to_City;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(City toCity) {
		this.toCity = toCity;
	}

	public void setFlights(List<ScheduledFlight> flights) {
		this.flights = flights;
	}

	public void setFh(List<FlightHistory> fh) {
		this.fh = fh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(flightNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return flightNo == other.flightNo;
	}

	@Override
	public String toString() {
		return "Flight [flightno=" + flightNo + ", durationinminutes=" + durationInMinutes + ", departuretime="
				+ departureTime + ", arrivaltime=" + arrivalTime + ", aircraft=" + aircraft + "]";
	}

	// Constructor
	public Flight() {
		super();
	}

	public Flight(int flightno, String fromcity, String tocity, int durationinminutes, LocalTime departuretime,
			LocalTime arrivaltime, String aircraft) {
		super();
		this.flightNo = flightno;
		this.from_City = fromcity;
		this.to_City = tocity;
		this.durationInMinutes = durationinminutes;
		this.departureTime = departuretime;
		this.arrivalTime = arrivaltime;
		this.aircraft = aircraft;
	}

}
