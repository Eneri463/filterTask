package com.example.testTask.repositories;

import com.example.testTask.models.FridgeCompressorType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FridgeCompressorTypeRepository extends JpaRepository<FridgeCompressorType, Long> {

    FridgeCompressorType getByNameIgnoreCase(String name);
}
