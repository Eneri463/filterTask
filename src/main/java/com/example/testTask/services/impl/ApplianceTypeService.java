package com.example.testTask.services.impl;

import com.example.testTask.models.ApplianceType;
import com.example.testTask.repositories.ApplianceTypeRepository;
import com.example.testTask.services.ApplianceTypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplianceTypeService implements ApplianceTypeServiceInterface {
    @Autowired
    private ApplianceTypeRepository repository;

    @Override
    public ApplianceType getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public ApplianceType create(ApplianceType type)
    {
        return repository.save(type);
    }
}
