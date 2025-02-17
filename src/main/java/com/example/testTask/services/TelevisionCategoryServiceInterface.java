package com.example.testTask.services;

import com.example.testTask.models.TelevisionCategory;

public interface TelevisionCategoryServiceInterface {

    public TelevisionCategory getByName(String name);
    public TelevisionCategory create(TelevisionCategory category);
}
