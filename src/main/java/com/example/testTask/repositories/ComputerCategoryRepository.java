package com.example.testTask.repositories;

import com.example.testTask.models.ComputerCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerCategoryRepository extends JpaRepository<ComputerCategory, Long> {

    ComputerCategory getByNameIgnoreCase(String name);
}
