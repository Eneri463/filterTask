package com.example.testTask.services.impl;

import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.Size;
import com.example.testTask.repositories.SizeRepository;
import com.example.testTask.services.SizeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService implements SizeServiceInterface {

    @Autowired
    private SizeRepository repository;

    @Override
    public Size getByNameAndType(String name, ApplianceType type)
    {
        return repository.getBySizeAndAppliance(name, type);
    }

    @Override
    public Size create(Size size)
    {
        return repository.save(size);
    }
}
