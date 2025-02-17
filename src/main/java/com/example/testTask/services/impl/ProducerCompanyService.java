package com.example.testTask.services.impl;

import com.example.testTask.models.ProducerCompany;
import com.example.testTask.repositories.ProducerCompanyRepository;
import com.example.testTask.services.ProducerCompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerCompanyService implements ProducerCompanyServiceInterface {

    @Autowired
    private ProducerCompanyRepository repository;

    @Override
    public ProducerCompany getByName(String name)
    {
        return repository.getByNameIgnoreCase(name);
    }

    @Override
    public ProducerCompany create(ProducerCompany company)
    {
        return repository.save(company);
    }
}
