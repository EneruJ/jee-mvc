package com.hitema.jee.mvc.services;

import com.hitema.jee.mvc.entities.City;

import java.util.List;

import com.hitema.jee.mvc.repositories.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService{

    private CityRepository repository;

    public CityServiceImpl(CityRepository repository) { this.repository = repository; }

    private static final Logger log = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    public City create(City city) {
        // Create city
        var newCity = repository.save(city);
        log.trace("New city created: {}", newCity);
        return newCity;
    }

    @Override
    public City read(Long id) {
        // Read city with id
        return repository.findById(id).orElse(null);
    }

    public City readByCity(String city) {
        // Read city with name
        return repository.findByCity(city);
    }

    @Override
    public City update(City city) {
        // Update city
        return repository.save(city);
    }

    @Override
    public void delete(Long id) {
        // Delete city with id
        repository.deleteById(id);
    }

    @Override
    public List<City> readAll() {
        // Read all cities
        return repository.findAll();
    }
}
