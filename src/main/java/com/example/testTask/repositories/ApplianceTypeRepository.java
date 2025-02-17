package com.example.testTask.repositories;

import com.example.testTask.models.ApplianceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplianceTypeRepository extends JpaRepository<ApplianceType, Long> {

    ApplianceType getByNameIgnoreCase(String name);
}
