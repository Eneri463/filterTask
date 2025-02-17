package com.example.testTask.repositories;

import com.example.testTask.models.TelevisionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionCategoryRepository extends JpaRepository<TelevisionCategory,Long> {

    TelevisionCategory getByNameIgnoreCase(String name);

}
