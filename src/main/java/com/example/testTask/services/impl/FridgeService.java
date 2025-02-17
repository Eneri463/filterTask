package com.example.testTask.services.impl;

import com.example.testTask.dto.FridgeDTO;
import com.example.testTask.models.Fridge;
import com.example.testTask.repositories.FridgeRepository;
import com.example.testTask.services.FridgeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FridgeService implements FridgeServiceInterface {

    @Autowired
    private FridgeRepository repository;

    @Override
    public List<FridgeDTO> getAllFridges(Specification<Fridge> spec)
    {
        List<FridgeDTO> listOfFridges = new ArrayList<>();

        for (Fridge fridge : repository.findAll(spec))
        {
            listOfFridges.add(fridge.createDTO());
        }

        return listOfFridges;
    }

    @Override
    public Fridge create(Fridge fridge)
    {
        return repository.save(fridge);
    }

}
