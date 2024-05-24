package com.example.myWarehouse.controller;

import com.example.myWarehouse.entity.StorageLocationEntity;
import com.example.myWarehouse.response.BaseResponse;
import com.example.myWarehouse.response.DataResponse;
import com.example.myWarehouse.response.ListResponse;
import com.example.myWarehouse.service.StorageLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/storageLocation")
@AllArgsConstructor
@Tag(name = "Места хранения препарата")
public class StorageLocationController {

    private final StorageLocationService service;

    @Operation(summary = "Добавить место хранения препарата")
    @PostMapping
    public ResponseEntity<DataResponse<StorageLocationEntity>> save(@RequestBody StorageLocationEntity storageLocation) {
        return ResponseEntity.ok(
                new DataResponse<StorageLocationEntity>(true, "место хранения сохранено", service.save(storageLocation)));
    }

    @Operation(summary = "Вывести все места хранения")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<StorageLocationEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<StorageLocationEntity>(true, "Список мест хранения", service.findAll()));
    }

    @Operation(summary = "Изменить место хранения")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody StorageLocationEntity storageLocation) {
        service.update(storageLocation);
        return ResponseEntity.ok(
                new BaseResponse(true, "место хранение изменено"));
    }

    @Operation(summary = "Удалить место хранение")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "место хранение удалено"));

        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}
