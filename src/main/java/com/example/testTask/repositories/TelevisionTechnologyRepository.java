package com.example.testTask.repositories;

import com.example.testTask.models.TelevisionTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelevisionTechnologyRepository extends JpaRepository<TelevisionTechnology, Long> {

    TelevisionTechnology getByNameIgnoreCase(String name);
}
