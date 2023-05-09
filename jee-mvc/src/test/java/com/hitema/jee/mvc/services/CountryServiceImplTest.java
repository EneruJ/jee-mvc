package com.hitema.jee.mvc.services;

import com.hitema.jee.mvc.entities.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
@SpringBootTest
class CountryServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);
    @Autowired
    private CountryService service;

    @BeforeEach
    void setUp() {
        log.info("<<<<Instanciation CountryService>>>>");
        assertNotNull(service,"CountryService NOT INSTANCED !!!");
    }

    @Order(1)
    @Test
    void create() {
        // Create new country
        var country = new Country();
        country.setCountry("Listenbourg");
        country.setLastUpdate(LocalDate.now().atStartOfDay());
        var newCountry = service.create(country);
        assertNotNull(newCountry,"WARNING Country not created !!!");
        log.trace("New country created: {}", newCountry);
    }

    @Order(2)
    @Test
    void read() {
        // Read country 1
        var country = service.read(1L);
        assertNotNull(country,"WARNING Country 1 not Found !!!");
        log.trace("Country 1 found: {}", country);
    }

    @Order(3)
    @Test
    void update() {
        // Update country 1
        var country = service.read(1L);
        assertNotNull(country,"WARNING Country 1 not Found !!!");
        country.setCountry("Hahaland");
        var updatedCountry = service.update(country);
        assertNotNull(updatedCountry,"WARNING Country 1 not Updated !!!");
        log.trace("Country 1 updated: {}", updatedCountry);
    }

    @Order(4)
    @Test
    void delete() {
        // Delete country 1
        var country = service.read(1L);
        assertNotNull(country,"WARNING Country 1 not Found !!!");
        // Delete country 1 with on cascade
        service.delete("Listenbourg");
        log.trace("Country 1 deleted");
    }

    @Order(5)
    @Test
    void readAll() {
        service.readAll().forEach(c->log.trace("{}",c));
    }
}