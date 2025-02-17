package com.example.testTask.services.impl;

import com.example.testTask.dto.VacuumCleanerDTO;
import com.example.testTask.models.VacuumCleaner;
import com.example.testTask.repositories.VacuumCleanerRepository;
import com.example.testTask.services.VacuumCleanerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacuumCleanerService implements VacuumCleanerServiceInterface {

    @Autowired
    private VacuumCleanerRepository repository;

    @Override
    public List<VacuumCleanerDTO> getAllVacuumCleaners(Specification<VacuumCleaner> spec)
    {
        List<VacuumCleanerDTO> listOfVacuumCleaners = new ArrayList<>();

        for (VacuumCleaner vacuumCleaner : repository.findAll(spec))
            listOfVacuumCleaners.add(vacuumCleaner.createDTO());

        return listOfVacuumCleaners;
    }

    @Override
    public VacuumCleaner create(VacuumCleaner vacuumCleaner)
    {
        return repository.save(vacuumCleaner);
    }

}
