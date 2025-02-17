package com.example.testTask.controllers;

import com.example.testTask.dto.FridgeDTO;
import com.example.testTask.dto.FridgeParams;
import com.example.testTask.dto.FridgeRequestDTO;
import com.example.testTask.models.Fridge;
import com.example.testTask.models.FridgeCompressorType;
import com.example.testTask.models.Model;
import com.example.testTask.services.FridgeCompressorTypeServiceInterface;
import com.example.testTask.services.FridgeServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.FridgeSpecification;
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
public class FridgeController {
    private FridgeSpecification fridgeSpecification;
    private FridgeServiceInterface fridgeService;

    @GetMapping(value= "/models", params = "type=fridge")
    public ResponseEntity<List<FridgeDTO>> getFridges(
            @Parameter(description = "Используйте параметр type=fridge с этими параметрами. Тело ответа - FridgeDTO" +
                    "Для сортировки укажите столбец сортировки (name, price) и по желанию тип (asc,desc) " +
                    "(например, sort=price,desc). Для поиска используйте параметр search")
            FridgeParams fridgeParams
    )
    {
        Specification<Fridge> spec = fridgeSpecification.build(fridgeParams);
        return ResponseEntity.ok(fridgeService.getAllFridges(spec));
    }

}
