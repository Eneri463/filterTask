package com.example.testTask.services;

import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.Size;

public interface SizeServiceInterface {

    public Size getByNameAndType(String name, ApplianceType type);
    public Size create(Size size);
}
