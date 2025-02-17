package com.example.testTask.services;

import com.example.testTask.models.ProducerCompany;

public interface ProducerCompanyServiceInterface {

    public ProducerCompany getByName(String name);
    public ProducerCompany create(ProducerCompany company);
}
