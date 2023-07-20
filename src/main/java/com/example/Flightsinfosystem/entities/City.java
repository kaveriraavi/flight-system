package com.example.Flightsinfosystem.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	@Column(name = "citycode") // primary key
	private String cityCode;
	private String name;
	@Column(name = "minutesfromutc")
	private int minutesFromUTC;
	private String country;

	// mapping with Flight
	@OneToMany(mappedBy = "fromCity")
	@JsonIgnore
	private List<Flight> fromFlights = new ArrayList<>();

	@OneToMany(mappedBy = "toCity")
	@JsonIgnore
	private List<Flight> toFlights = new ArrayList<>();

	// Getters and setters

	public String getCityCode() {
		return cityCode;
	}

	public String getName() {
		return name;
	}

	public int getMinutesFromUTC() {
		return minutesFromUTC;
	}

	public String getCountry() {
		return country;
	}

	public List<Flight> getFromFlights() {
		return fromFlights;
	}

	public List<Flight> getToFlights() {
		return toFlights;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMinutesFromUTC(int minutesFromUTC) {
		this.minutesFromUTC = minutesFromUTC;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFromFlights(List<Flight> fromFlights) {
		this.fromFlights = fromFlights;
	}

	public void setToFlights(List<Flight> toFlights) {
		this.toFlights = toFlights;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cityCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(cityCode, other.cityCode);
	}

	@Override
	public String toString() {
		return name;
	}

	// constructor
	public City() {
		super();

	}

	public City(String citycode, String name, int minutesfromutc, String country) {
		super();
		this.cityCode = citycode;
		this.name = name;
		this.minutesFromUTC = minutesfromutc;
		this.country = country;
	}

}
