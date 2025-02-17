package com.example.testTask.services.impl;

import com.example.testTask.models.TelevisionCategory;
import com.example.testTask.repositories.TelevisionCategoryRepository;
import com.example.testTask.services.TelevisionCategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelevisionCategoryService implements TelevisionCategoryServiceInterface {

    @Autowired
    private TelevisionCategoryRepository repository;

    @Override
    public TelevisionCategory getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public TelevisionCategory create(TelevisionCategory category)
    {
        return repository.save(category);
    }
}
