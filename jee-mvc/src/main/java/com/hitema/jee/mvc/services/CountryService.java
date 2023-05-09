package com.hitema.jee.mvc.services;

import com.hitema.jee.mvc.entities.Country;

import java.util.List;

public interface CountryService {
    Country create(Country country);

    Country read(Long id);

    Country update(Country country);

    void delete(Long id);

    List<Country> readAll();
}
