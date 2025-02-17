package com.example.testTask.services;

import com.example.testTask.models.FridgeCompressorType;

public interface FridgeCompressorTypeServiceInterface {
    public FridgeCompressorType getByName(String name);
    public FridgeCompressorType create(FridgeCompressorType compressorType);
}
