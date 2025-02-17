package com.example.testTask.services.impl;

import com.example.testTask.models.ComputerCategory;
import com.example.testTask.repositories.ComputerCategoryRepository;
import com.example.testTask.services.ComputerCategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerCategoryService implements ComputerCategoryServiceInterface {

    @Autowired
    private ComputerCategoryRepository repository;

    @Override
    public ComputerCategory getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public ComputerCategory create(ComputerCategory category)
    {
        return repository.save(category);
    }
}
