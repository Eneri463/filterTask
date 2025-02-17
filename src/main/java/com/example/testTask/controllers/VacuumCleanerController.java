package com.example.testTask.controllers;

import com.example.testTask.dto.VacuumCleanerDTO;
import com.example.testTask.dto.VacuumCleanerParams;
import com.example.testTask.dto.VacuumCleanerRequestDTO;
import com.example.testTask.models.Model;
import com.example.testTask.models.VacuumCleaner;
import com.example.testTask.services.VacuumCleanerServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.VacuumCleanerSpecification;
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
public class VacuumCleanerController {

    private CreateCurrentModelService createCurrentModelService;
    private VacuumCleanerSpecification vacuumCleanerSpecification;
    private VacuumCleanerServiceInterface vacuumCleanerService;



    @GetMapping(value= "/models", params = "type=vacuum_cleaner")
    public ResponseEntity<List<VacuumCleanerDTO>> getVacuumCleaners(
            @Parameter(description = "Используйте параметр type=vacuum_cleaner с этими параметрами. " +
                    "Тело ответа - VacuumCleanerDTO Для сортировки укажите столбец сортировки " +
                    "(name, price) и по желанию тип (asc,desc) (например, sort=price,desc). " +
                    "Для поиска используйте параметр search")  VacuumCleanerParams vacuumCleanerParams
    )
    {
        Specification<VacuumCleaner> spec = vacuumCleanerSpecification.build(vacuumCleanerParams);
        return ResponseEntity.ok(vacuumCleanerService.getAllVacuumCleaners(spec));
    }

    @PostMapping("/model/create/vacuumCleaner")
    public ResponseEntity<VacuumCleanerDTO> createVacuumCleaner(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Все значения NotNull. ApplianceId - id таблицы " +
                    "'техника'(сущность appliance), с которой будет связана добавляемая модель пылесоса")
            @RequestBody @Valid VacuumCleanerRequestDTO request)
    {
        Model model = createCurrentModelService.createModel(request);
        VacuumCleaner vacuumCleaner = new VacuumCleaner(null, request.getVolume(), request.getNumberOfModes(), model);

        return new ResponseEntity<>(vacuumCleanerService.create(vacuumCleaner).createDTO(), HttpStatus.CREATED);
    }
}
