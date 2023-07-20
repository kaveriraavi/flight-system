package com.example.Flightsinfosystem.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flightshistory")
@IdClass(FlightDate.class)
public class FlightHistory {
	@Id
	private int flightNo;
	@Id
	private LocalDate deptDate;
	@Column(name = "depttime")
	private LocalTime deptTime;
	@Column(name = "arrivaldate")
	private LocalDate arrivalDate;
	@Column(name = "arrivaltime")
	private LocalTime arrivalTime;
	@Column(name = "fromcity")
	private String from_City;
	@Column(name = "tocity")
	private String to_City;
	@Column(name = "durationinminutes")
	private int durationInMinutes;
	private String aircraft;
	private String remarks;

	// mapping with city
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "fromcity", insertable = false, updatable = false)
	private City fromCity;

	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "tocity", insertable = false, updatable = false)
	private City toCity;

	// mapping with flight
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "flightno", insertable = false, updatable = false)
	private Flight fn;

	// Getters and Setters

	@Override
	public int hashCode() {
		return Objects.hash(deptDate, flightNo);
	}

	public int getFlightNo() {
		return flightNo;
	}

	public LocalDate getDeptDate() {
		return deptDate;
	}

	public LocalTime getDeptTime() {
		return deptTime;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
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

	public String getAircraft() {
		return aircraft;
	}

	public String getRemarks() {
		return remarks;
	}

	public City getFromCity() {
		return fromCity;
	}

	public City getToCity() {
		return toCity;
	}

	public Flight getFn() {
		return fn;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public void setDeptDate(LocalDate deptDate) {
		this.deptDate = deptDate;
	}

	public void setDeptTime(LocalTime deptTime) {
		this.deptTime = deptTime;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	public void setToCity(City toCity) {
		this.toCity = toCity;
	}

	public void setFn(Flight fn) {
		this.fn = fn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightHistory other = (FlightHistory) obj;
		return Objects.equals(deptDate, other.deptDate) && flightNo == other.flightNo;
	}

	@Override
	public String toString() {
		return "FlightHistory [flightNo=" + flightNo + ", deptDate=" + deptDate + ", deptTime=" + deptTime
				+ ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", from_City=" + from_City
				+ ", to_City=" + to_City + ", durationInMinutes=" + durationInMinutes + ", aircraft=" + aircraft
				+ ", remarks=" + remarks + "]";
	}

}
