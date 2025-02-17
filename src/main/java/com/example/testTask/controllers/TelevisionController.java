package com.example.testTask.controllers;

import com.example.testTask.dto.TelevisionDTO;
import com.example.testTask.dto.TelevisionParams;
import com.example.testTask.dto.TelevisionRequestDTO;
import com.example.testTask.models.*;
import com.example.testTask.services.*;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.TelevisionSpecification;
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
public class TelevisionController {

    private CreateCurrentModelService createCurrentModelService;
    private TelevisionSpecification televisionSpecification;
    private TelevisionServiceInterface televisionService;
    private TelevisionCategoryServiceInterface televisionCategoryService;
    private TelevisionTechnologyServiceInterface televisionTechnologyService;

    @GetMapping(value= "/models", params = "type=television")
    public ResponseEntity<List<TelevisionDTO>> getTelevisions(
            @Parameter(description = "Используйте параметр type=television с этими параметрами. " +
                    "Тело ответа - TelevisionDTO Для сортировки укажите столбец сортировки (name, price) " +
                    "и по желанию тип (asc,desc) (например, sort=price,desc). " +
                    "Для поиска используйте параметр search")  TelevisionParams televisionParams
    )
    {
        Specification<Television> spec = televisionSpecification.build(televisionParams);
        return ResponseEntity.ok(televisionService.getAllTelevisions(spec));
    }

    @PostMapping("/model/create/television")
    public ResponseEntity<TelevisionDTO> createTelevision(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Все значения NotNull. ApplianceId - id таблицы " +
                    "'техника'(сущность appliance), с которой будет связана добавляемая модель телевизора")
            @RequestBody @Valid TelevisionRequestDTO request)
    {
        TelevisionCategory category = televisionCategoryService.getByName(request.getCategory());

        if (category == null)
            category = televisionCategoryService.create(new TelevisionCategory(null, request.getCategory()));

        TelevisionTechnology technology = televisionTechnologyService.getByName(request.getTechnology());

        if (technology == null)
            technology = televisionTechnologyService.create(new TelevisionTechnology(null, request.getTechnology()));

        Model model = createCurrentModelService.createModel(request);

        Television television = new Television(null, category, technology, model);

        return new ResponseEntity<>(televisionService.create(television).createDTO(), HttpStatus.CREATED);

    }
}
