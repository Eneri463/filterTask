package com.example.testTask.services.impl;

import com.example.testTask.models.FridgeCompressorType;
import com.example.testTask.repositories.FridgeCompressorTypeRepository;
import com.example.testTask.services.FridgeCompressorTypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeCompressorTypeService implements FridgeCompressorTypeServiceInterface {

    @Autowired
    private FridgeCompressorTypeRepository repository;

    @Override
    public FridgeCompressorType getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public FridgeCompressorType create(FridgeCompressorType compressorType)
    {
        return repository.save(compressorType);
    }
}
