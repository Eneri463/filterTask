package com.example.testTask.controllers;

import com.example.testTask.dto.ApplianceDTO;
import com.example.testTask.models.Appliance;
import com.example.testTask.models.ApplianceType;
import com.example.testTask.models.ProducerCompany;
import com.example.testTask.models.ProducerCountry;
import com.example.testTask.services.ApplianceServiceInterface;
import com.example.testTask.services.ApplianceTypeServiceInterface;
import com.example.testTask.services.ProducerCompanyServiceInterface;
import com.example.testTask.services.ProducerCountryServiceInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class ApplianceController {

    private ApplianceServiceInterface applianceService;
    private ApplianceTypeServiceInterface applianceTypeService;
    private ProducerCountryServiceInterface producerCountryService;
    private ProducerCompanyServiceInterface producerCompanyService;


    @PostMapping(value= "/appliance/create")
    public ResponseEntity<ApplianceDTO> createAppliance(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "ApplianceId необязательный параметр, остальные значения NotNull")
            @RequestBody
            ApplianceDTO request
    )
    {
        boolean flag = false; // проверка, было ли хотя бы одно введённое значение уникальным

        ApplianceType type = applianceTypeService.getByName(request.getType());

        if (type == null)
        {
            flag = true;
            type = applianceTypeService.create(new ApplianceType(null, request.getType()));
        }

        ProducerCompany company = producerCompanyService.getByName(request.getCompany());

        if (company == null)
        {
            flag = true;
            company = producerCompanyService.create(new ProducerCompany(null, request.getCompany()));
        }

        ProducerCountry country = producerCountryService.getByName(request.getCountry());

        if (country == null)
        {
            flag = true;
            country = producerCountryService.create(new ProducerCountry(null, request.getCountry()));
        }

        Appliance appliance;

        if (!flag)
        {
            appliance = applianceService.getByTypeCompanyCountry(type, company, country);

            if (appliance != null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This appliance already exists");
        }

        appliance = applianceService.save(new Appliance(null, type, country, company, request.getOnlineOrder(), request.getInstallment()));

        return ResponseEntity.ok(appliance.createDTO());
    }

}
