package com.example.testTask.repositories;

import com.example.testTask.models.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long>, JpaSpecificationExecutor<VacuumCleaner> {
}
