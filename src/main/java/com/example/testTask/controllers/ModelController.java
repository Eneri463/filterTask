package com.example.testTask.controllers;

import com.example.testTask.dto.*;
import com.example.testTask.models.*;
import com.example.testTask.services.*;
import com.example.testTask.specifications.*;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@AllArgsConstructor
public class ModelController {
    private ModelServiceInterface modelService;

    @GetMapping(value= "/models", params = "!type")
    public ResponseEntity<List<ModelDTO>> getAllAppliances(
            @Parameter(description = "Эти параметры применяются, когда параметр type отсутствует (равен null). Такой запрос позволяет " +
                    "просмотреть всю технику независимо от её вида (по общим атрибутам). Тело ответа - ModelDTO." +
                    "Для сортировки укажите столбец сортировки (name, price) и по желанию тип (asc,desc) " +
                    "(например, sort=price,desc). Для поиска используйте параметр search") ParamsDTO paramsDTO
    )
    {
        Specification<Model> spec = GeneralSpecification.mainFilters(paramsDTO);
        return ResponseEntity.ok(modelService.getAllModels(spec));
    }

}
