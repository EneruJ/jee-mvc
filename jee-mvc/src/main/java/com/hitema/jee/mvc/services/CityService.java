package com.hitema.jee.mvc.services;

import com.hitema.jee.mvc.entities.City;

import java.util.List;

public interface CityService {
    City create(City city);

    City read(Long id);

    City readByCity(String city);

    City update(City city);

    void delete(Long id);

    List<City> readAll();

}
