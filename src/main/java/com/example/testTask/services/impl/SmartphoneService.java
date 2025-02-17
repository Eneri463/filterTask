package com.example.testTask.services.impl;

import com.example.testTask.dto.SmartphoneDTO;
import com.example.testTask.models.Smartphone;
import com.example.testTask.repositories.SmartphoneRepository;
import com.example.testTask.services.SmartphoneServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmartphoneService implements SmartphoneServiceInterface {

    @Autowired
    private SmartphoneRepository repository;

    @Override
    public List<SmartphoneDTO> getAllSmartphones(Specification<Smartphone> spec)
    {
        List<SmartphoneDTO> listOfSmartphones = new ArrayList<>();

        for (Smartphone smartphone : repository.findAll(spec))
            listOfSmartphones.add(smartphone.createDTO());

        return listOfSmartphones;
    }

    @Override
    public Smartphone create(Smartphone smartphone)
    {
        return repository.save(smartphone);
    }
}
