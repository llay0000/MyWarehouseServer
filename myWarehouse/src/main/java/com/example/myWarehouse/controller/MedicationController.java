package com.example.myWarehouse.controller;

import com.example.myWarehouse.entity.MedicationEntity;
import com.example.myWarehouse.response.BaseResponse;
import com.example.myWarehouse.response.DataResponse;
import com.example.myWarehouse.response.ListResponse;
import com.example.myWarehouse.service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/medication")
@AllArgsConstructor
@Tag(name = "Препарат")
public class MedicationController {

    private final MedicationService service;

    @Operation(summary = "Добавить препарат")
    @PostMapping
    public ResponseEntity<DataResponse<MedicationEntity>> save(@RequestBody MedicationEntity medication) {
        return ResponseEntity.ok(
                new DataResponse<MedicationEntity>(true, "Препарат сохранен", service.save(medication)));
    }

    @Operation(summary = "Вывести все препараты")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<MedicationEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<MedicationEntity>(true, "Список препаратов", service.findAll()));
    }

    @Operation(summary = "Изменить препарат")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody MedicationEntity medication) {
        service.update(medication);
        return ResponseEntity.ok(
                new BaseResponse(true, "Препарат изменён"));
    }

    @Operation(summary = "Удалить препарат")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Препарат удалён"));

        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

    @Operation(summary = "Вывести все препараты с указанным рецептом")
    @GetMapping("/withRecipe")
    public ResponseEntity<ListResponse<MedicationEntity>> getAllWithRecipe(@RequestParam(required = false) String recipe) {
        List<MedicationEntity> medications;
        if (recipe != null) {
            medications = service.findAllWithRecipe(recipe);
        } else {
            medications = service.findAllWithoutRecipe();
        }
        return ResponseEntity.ok(
                new ListResponse<MedicationEntity>(true, "Список препаратов", medications));
    }

}
