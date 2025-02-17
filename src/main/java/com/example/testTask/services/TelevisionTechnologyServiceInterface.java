package com.example.testTask.services;

import com.example.testTask.models.TelevisionTechnology;

public interface TelevisionTechnologyServiceInterface {

    public TelevisionTechnology getByName(String name);
    public TelevisionTechnology create(TelevisionTechnology technology);
}
