package com.hitema.jee.mvc.services;
import com.hitema.jee.mvc.entities.Country;
import com.hitema.jee.mvc.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Override
    public Country create(Country country) {
        var newCountry = repository.save(country);
        log.trace("New country created: {}", newCountry);
        return newCountry;
    }

    @Override
    public Country read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Country update(Country country) {
        return repository.save(country);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Country> readAll() {
        return repository.findAll();
    }
}
