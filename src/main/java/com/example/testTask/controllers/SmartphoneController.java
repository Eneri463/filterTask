package com.example.testTask.controllers;

import com.example.testTask.dto.SmartphoneDTO;
import com.example.testTask.dto.SmartphoneParams;
import com.example.testTask.dto.SmartphoneRequestDTO;
import com.example.testTask.models.Model;
import com.example.testTask.models.Smartphone;
import com.example.testTask.services.SmartphoneServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.SmartphoneSpecification;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class SmartphoneController {
    private SmartphoneSpecification smartphoneSpecification;
    private SmartphoneServiceInterface smartphoneService;

    @GetMapping(value= "/models", params = "type=smartphone")
    public ResponseEntity<List<SmartphoneDTO>> getSmartphones(
            @Parameter(description = "Используйте параметр type=smartphone с этими параметрами. " +
                    "Тело ответа - SmartphoneDTO. Для сортировки укажите столбец сортировки (name, price) " +
                    "и по желанию тип (asc,desc) (например, sort=price,desc). " +
                    "Для поиска используйте параметр search")
            SmartphoneParams smartphoneParams
    )
    {
        Specification<Smartphone> spec = smartphoneSpecification.build(smartphoneParams);
        return ResponseEntity.ok(smartphoneService.getAllSmartphones(spec));
    }
}
