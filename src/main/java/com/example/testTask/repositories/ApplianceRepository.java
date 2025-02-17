package com.example.testTask.repositories;

import com.example.testTask.models.Appliance;
import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    Appliance getByTypeAndProducerCompanyAndProducerCountry(ApplianceType type, ProducerCompany company, ProducerCountry country);
}
