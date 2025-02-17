package com.example.testTask.services.impl;

import com.example.testTask.models.ComputerProcessorType;
import com.example.testTask.repositories.ComputerProcessorTypeRepository;
import com.example.testTask.services.ComputerProcessorTypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerProcessorTypeService implements ComputerProcessorTypeServiceInterface {

    @Autowired
    private ComputerProcessorTypeRepository repository;

    @Override
    public ComputerProcessorType getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public ComputerProcessorType create(ComputerProcessorType processorType)
    {
        return repository.save(processorType);
    }
}
