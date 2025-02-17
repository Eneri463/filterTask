package com.example.testTask.repositories;

import com.example.testTask.models.Computer;
import com.example.testTask.models.ComputerProcessorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerProcessorTypeRepository extends JpaRepository<ComputerProcessorType, Long> {

    ComputerProcessorType getByNameIgnoreCase(String name);
}
