package com.example.testTask.services;

import com.example.testTask.models.ComputerProcessorType;

public interface ComputerProcessorTypeServiceInterface {

    public ComputerProcessorType getByName(String name);
    public ComputerProcessorType create(ComputerProcessorType processorType);
}
