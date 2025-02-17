package com.example.testTask.services.impl;

import com.example.testTask.dto.ComputerDTO;
import com.example.testTask.models.Computer;
import com.example.testTask.repositories.ComputerRepository;
import com.example.testTask.services.ComputerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerService implements ComputerServiceInterface {

    @Autowired
    private ComputerRepository repository;

    @Override
    public List<ComputerDTO> getAllComputers(Specification<Computer> spec)
    {
        List<ComputerDTO> listOfComputers = new ArrayList<>();

        for (Computer computer : repository.findAll(spec))
            listOfComputers.add(computer.createDTO());

        return listOfComputers;
    }

    @Override
    public  Computer create(Computer computer)
    {
        return repository.save(computer);
    }

}
