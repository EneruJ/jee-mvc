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
        return null;
    }

    @Override
    public City read(Long id) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<City> readAll() {
        return null;
    }
}
