package com.example.testTask.services;

import com.example.testTask.models.ProducerCountry;

public interface ProducerCountryServiceInterface {

    public ProducerCountry getByName(String name);

    public ProducerCountry create(ProducerCountry country);
}
