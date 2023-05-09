package com.hitema.jee.mvc.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hitema.jee.mvc.entities.City;
import com.hitema.jee.mvc.entities.Country;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);

    @Autowired
    private CityService service;

    @BeforeEach
    void setUp() {
        log.info("<<<<Instanciation CountryService>>>>");
        assertNotNull(service,"CountryService NOT INSTANCED !!!");
    }

    @Order(1)
    @Test
    void create() {
        // Create new city
        var city = new City();
        city.setCity("Listenbourg");
        // city Set Country with country named France
        var country = new Country();
        country.setCountry("Hahahaha");
        country.setId(11L);
        country.setLastUpdate(LocalDate.now().atStartOfDay());
        city.setCountry(country);
        assertNotNull(city,"WARNING City not created !!!");
        log.trace("New city created: {}", city);
    }

    @Order(2)
    @Test
    void read() {
        // Read city 1
        var city = service.read(1L);
        assertNotNull(city,"WARNING City 1 not Found !!!");
        log.trace("City 1 found: {}", city);
    }

    @Order(3)
    @Test
    void readByCity(){
        // Read city Listenbourg
        var city = service.readByCity("Listenbourg");
        assertNotNull(city,"WARNING City Listenbourg not Found !!!");
        log.trace("City Listenbourg found: {}", city);
    }

    @Order(4)
    @Test
    void readByCityPart(){
        // Read cities containing "bourd"
        var cities = service.readByCity("%bourg");
        assertNotNull(cities,"WARNING Cities containing %bourg not Found !!!");
        cities.readAll(city -> log.trace("City containing %bourg found: {}", city));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void readAll() {
        service.readAll().forEach(city -> log.trace("City: {}", city));
    }
}