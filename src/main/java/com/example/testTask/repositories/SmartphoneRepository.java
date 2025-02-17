package com.example.testTask.repositories;

import com.example.testTask.models.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long>, JpaSpecificationExecutor<Smartphone> {
}
