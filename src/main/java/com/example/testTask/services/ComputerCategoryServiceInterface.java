package com.example.testTask.services;

import com.example.testTask.models.ComputerCategory;

public interface ComputerCategoryServiceInterface {

    public ComputerCategory getByName(String name);
    public ComputerCategory create(ComputerCategory category);
}
