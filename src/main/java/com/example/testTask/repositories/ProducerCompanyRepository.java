package com.example.testTask.repositories;

import com.example.testTask.models.ProducerCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerCompanyRepository extends JpaRepository<ProducerCompany, Long> {

    ProducerCompany getByNameIgnoreCase(String name);
}
