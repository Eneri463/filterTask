package com.example.testTask.services.impl;

import com.example.testTask.models.Colour;
import com.example.testTask.repositories.ColourRepository;
import com.example.testTask.services.ColourServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColourService implements ColourServiceInterface {

    @Autowired
    private ColourRepository repository;

    @Override
    public Colour getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public Colour create(Colour colour)
    {
        return repository.save(colour);
    }
}
