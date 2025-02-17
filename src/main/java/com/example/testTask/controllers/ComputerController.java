package com.example.testTask.controllers;

import com.example.testTask.dto.ComputerDTO;
import com.example.testTask.dto.ComputerParams;
import com.example.testTask.dto.ComputerRequestDTO;
import com.example.testTask.dto.ModelRequestDTO;
import com.example.testTask.models.Computer;
import com.example.testTask.models.ComputerCategory;
import com.example.testTask.models.ComputerProcessorType;
import com.example.testTask.models.Model;
import com.example.testTask.services.ComputerCategoryServiceInterface;
import com.example.testTask.services.ComputerProcessorTypeServiceInterface;
import com.example.testTask.services.ComputerServiceInterface;
import com.example.testTask.services.impl.CreateCurrentModelService;
import com.example.testTask.specifications.ComputerSpecification;
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
public class ComputerController {

    private ComputerSpecification computerSpecification;
    private ComputerServiceInterface computerService;

    @GetMapping(value= "/models", params = "type=computer")
    public ResponseEntity<List<ComputerDTO>> getComputers(
            @Parameter(description = "Используйте type=computer с этими параметрами. Тело ответа - ComputerDTO. " +
                    "Для сортировки укажите столбец сортировки (name, price) и по желанию тип (asc,desc) " +
                    "(например, sort=price,desc). Для поиска используйте параметр search")
            ComputerParams computerParams
    )
    {
        Specification<Computer> spec = computerSpecification.build(computerParams);
        return ResponseEntity.ok(computerService.getAllComputers(spec));
    }
}
