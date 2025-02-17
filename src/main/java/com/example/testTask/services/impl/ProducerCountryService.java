package com.example.testTask.services.impl;

import com.example.testTask.models.ProducerCountry;
import com.example.testTask.repositories.ProducerCountryRepository;
import com.example.testTask.services.ProducerCountryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerCountryService implements ProducerCountryServiceInterface {

    @Autowired
    private ProducerCountryRepository repository;

    @Override
    public ProducerCountry getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public ProducerCountry create(ProducerCountry country)
    {
        return repository.save(country);
    }
}
