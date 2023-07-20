package com.example.Flightsinfosystem.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Flightsinfosystem.entities.City;

public interface CityRepo extends JpaRepository<City, String> {

}
