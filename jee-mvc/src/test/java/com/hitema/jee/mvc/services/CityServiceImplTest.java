package com.hitema.jee.mvc.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceImplTest {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImplTest.class);

    @Autowired
    private CityService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void create() {
    }

    @Test
    void read() {
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