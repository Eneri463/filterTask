package com.example.testTask.repositories;

import com.example.testTask.models.ProducerCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerCountryRepository extends JpaRepository<ProducerCountry, Long> {

    ProducerCountry getByNameIgnoreCase(String name);
}
