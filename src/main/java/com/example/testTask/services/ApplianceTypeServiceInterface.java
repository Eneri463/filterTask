package com.example.testTask.services;

import com.example.testTask.models.ApplianceType;

public interface ApplianceTypeServiceInterface {

    public ApplianceType getByName(String name);
    public ApplianceType create(ApplianceType type);
}
