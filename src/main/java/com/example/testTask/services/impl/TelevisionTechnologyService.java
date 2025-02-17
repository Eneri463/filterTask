package com.example.testTask.services.impl;

import com.example.testTask.models.TelevisionTechnology;
import com.example.testTask.repositories.TelevisionTechnologyRepository;
import com.example.testTask.services.TelevisionTechnologyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelevisionTechnologyService implements TelevisionTechnologyServiceInterface {

    @Autowired
    private TelevisionTechnologyRepository repository;

    @Override
    public TelevisionTechnology getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public TelevisionTechnology create(TelevisionTechnology technology)
    {
        return repository.save(technology);
    }

}
