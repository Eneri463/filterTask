package com.example.testTask.services;

import com.example.testTask.dto.ModelDTO;
import com.example.testTask.models.Model;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ModelServiceInterface {

    public List<ModelDTO> getAllModels(Specification<Model> spec);
    public Model create(Model model);

}
