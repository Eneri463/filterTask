package com.example.testTask.services.impl;

import com.example.testTask.models.Appliance;
import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;
import com.example.testTask.repositories.ApplianceRepository;
import com.example.testTask.services.ApplianceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApplianceService implements ApplianceServiceInterface {
    @Autowired
    private ApplianceRepository repository;

    @Override
    public List<Appliance> getAll()
    {
        return repository.findAll();
    }

    @Override
    public Appliance getById(Long id)
    {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Appliance not found"));
    }

    @Override
    public Appliance getByTypeCompanyCountry(ApplianceType type, ProducerCompany company, ProducerCountry country)
    {
        return repository.getByTypeAndProducerCompanyAndProducerCountry(type, company, country);
    }


    @Override
    public Appliance save(Appliance appliance)
    {
        return repository.save(appliance);
    }
}
