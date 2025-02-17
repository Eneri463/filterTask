package com.example.testTask.services;

import com.example.testTask.dto.VacuumCleanerDTO;
import com.example.testTask.models.VacuumCleaner;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface VacuumCleanerServiceInterface{

    public List<VacuumCleanerDTO> getAllVacuumCleaners(Specification<VacuumCleaner> spec);

    public VacuumCleaner create(VacuumCleaner vacuumCleaner);
}
