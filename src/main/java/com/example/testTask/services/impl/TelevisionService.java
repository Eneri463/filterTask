package com.example.testTask.services.impl;

import com.example.testTask.dto.TelevisionDTO;
import com.example.testTask.models.Television;
import com.example.testTask.repositories.TelevisionRepository;
import com.example.testTask.services.TelevisionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService implements TelevisionServiceInterface {

    @Autowired
    private TelevisionRepository repository;

    @Override
    public List<TelevisionDTO> getAllTelevisions(Specification<Television> spec)
    {
        List<TelevisionDTO> listOfTelevisions = new ArrayList<>();

        for (Television television : repository.findAll(spec))
            listOfTelevisions.add(television.createDTO());

        return listOfTelevisions;
    }

    @Override
    public Television create(Television television)
    {
        return repository.save(television);
    }
}
