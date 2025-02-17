package com.example.testTask.repositories;

import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Long> {

    Size getBySizeAndAppliance(String name, ApplianceType appliance);

}
