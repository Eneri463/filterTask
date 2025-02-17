package com.example.testTask.services;

import com.example.testTask.dto.TelevisionDTO;
import com.example.testTask.models.Television;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface TelevisionServiceInterface {

    public List<TelevisionDTO> getAllTelevisions(Specification<Television> spec);
    public Television create(Television television);
}
