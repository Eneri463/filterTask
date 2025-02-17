package com.example.testTask.services;

import com.example.testTask.models.Colour;

public interface ColourServiceInterface {

    public Colour getByName(String name);
    public Colour create(Colour colour);
}
