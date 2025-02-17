package com.example.testTask.services;

import com.example.testTask.dto.SmartphoneDTO;
import com.example.testTask.models.Smartphone;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SmartphoneServiceInterface {

    public List<SmartphoneDTO> getAllSmartphones(Specification<Smartphone> spec);
    public Smartphone create(Smartphone smartphone);
}
