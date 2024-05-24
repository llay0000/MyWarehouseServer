package com.example.myWarehouse.controller;

import com.example.myWarehouse.entity.ManufacturerCompanyEntity;
import com.example.myWarehouse.response.BaseResponse;
import com.example.myWarehouse.response.DataResponse;
import com.example.myWarehouse.response.ListResponse;
import com.example.myWarehouse.service.ManufacturerCompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/manufacturerCompany")
@AllArgsConstructor
@Tag(name = "Фирмы-производителя препарата")
public class ManufacturerCompanyController {

    private final ManufacturerCompanyService service;

    @Operation(summary = "Добавить фирму-производителя")
    @PostMapping
    public ResponseEntity<DataResponse<ManufacturerCompanyEntity>> save(@RequestBody ManufacturerCompanyEntity manufacturerCompany) {
        return ResponseEntity.ok(
                new DataResponse<ManufacturerCompanyEntity>(true, "фирма-производителя сохранен", service.save(manufacturerCompany)));
    }

    @Operation(summary = "Вывести все фирмы-производителя")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<ManufacturerCompanyEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ManufacturerCompanyEntity>(true, "Список фирм-производителя", service.findAll()));
    }

    @Operation(summary = "Изменить фирму-производителя")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ManufacturerCompanyEntity manufacturerCompany) {
        service.update(manufacturerCompany);
        return ResponseEntity.ok(
                new BaseResponse(true, "фирма-производителя изменена"));
    }

    @Operation(summary = "Удалить фирму-производителя")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "фирма-производителя удалена"));

        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }

}
