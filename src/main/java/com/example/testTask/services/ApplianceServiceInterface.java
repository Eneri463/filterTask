package com.example.testTask.services;

import com.example.testTask.models.Appliance;
import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;

import java.util.List;

public interface ApplianceServiceInterface {
    public List<Appliance> getAll();
    public Appliance getById(Long id);
    public Appliance getByTypeCompanyCountry(ApplianceType type, ProducerCompany company, ProducerCountry country);
    public Appliance save(Appliance appliance);
}
