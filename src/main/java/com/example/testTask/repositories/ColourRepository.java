package com.example.testTask.repositories;

import com.example.testTask.models.Colour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColourRepository extends JpaRepository<Colour, Long> {

    Colour getByNameIgnoreCase(String name);
}
