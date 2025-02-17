package com.example.testTask.services.impl;

import com.example.testTask.dto.ModelDTO;
import com.example.testTask.models.Model;
import com.example.testTask.repositories.ModelRepository;
import com.example.testTask.services.ModelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService implements ModelServiceInterface {

        @Autowired
        private ModelRepository repository;

        @Override
        public List<ModelDTO> getAllModels(Specification<Model> spec)
        {
                List<ModelDTO> listOfModels = new ArrayList<>();

                for (Model model : repository.findAll(spec))
                {
                        listOfModels.add(model.createDTO());
                }

                return listOfModels;
        }

        @Override
        public Model create(Model model)
        {
                return repository.save(model);
        }
}
