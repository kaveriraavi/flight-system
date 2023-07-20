package com.example.Flightsinfosystem.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FlightDate implements Serializable {
	@Column(name="flightno")
	private int flightNo;
	@Column(name="deptdate")
	private LocalDate deptDate;
	//overriding Object class methods

	@Override
	public int hashCode() {
		return Objects.hash(deptDate, flightNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDate other = (FlightDate) obj;
		return Objects.equals(deptDate, other.deptDate) && flightNo == other.flightNo;
	}

	public int getFlightno() {
		return flightNo;
	}

	public void setFlightno(int flightno) {
		this.flightNo = flightno;
	}

	public LocalDate getDeptdate() {
		return deptDate;
	}

	public void setDeptdate(LocalDate deptdate) {
		this.deptDate = deptdate;
	}
}
