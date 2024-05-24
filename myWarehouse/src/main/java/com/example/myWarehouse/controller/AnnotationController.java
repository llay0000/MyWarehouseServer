package com.example.myWarehouse.controller;

import com.example.myWarehouse.entity.AnnotationEntity;
import com.example.myWarehouse.response.BaseResponse;
import com.example.myWarehouse.response.DataResponse;
import com.example.myWarehouse.response.ListResponse;
import com.example.myWarehouse.service.AnnotationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/annotation")
@AllArgsConstructor
@Tag(name = "Аннотация/описание")
public class AnnotationController {

    private final AnnotationService service;

    @Operation(summary = "Добавить описание",
            description = "Этот метод позволяет добавить новое описание в систему.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AnnotationEntity.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DataResponse.class)
                            )),
                    @ApiResponse(responseCode = "400", description = "Ошибка при сохранении описания",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            ))
            })
    @PostMapping
    public ResponseEntity<DataResponse<AnnotationEntity>> save(@RequestBody AnnotationEntity annotation) {
        return ResponseEntity.ok(
                new DataResponse<AnnotationEntity>(true, "описание сохранено", service.save(annotation)));
    }

    @Operation(summary = "Вывод аннотаций",
            description = "Этот метод возвращает список всех описаний, сохраненных в системе.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ListResponse.class)
                            )),
                    @ApiResponse(responseCode = "400", description = "Ошибка при получении списка описаний",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            ))
            })
    @GetMapping("/all")
    public ResponseEntity<ListResponse<AnnotationEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<AnnotationEntity>(true, "список аннотаций", service.findAll()));
    }

    @Operation(summary = "Изменить описание",
            description = "Этот метод позволяет изменить существующее описание.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AnnotationEntity.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )),
                    @ApiResponse(responseCode = "400", description = "Ошибка при обновлении описания",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            ))
            })
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody AnnotationEntity annotation) {
        service.update(annotation);
        return ResponseEntity.ok(
                new BaseResponse(true, "описание изменино"));
    }

    @Operation(summary = "Удалить описание",
            description = "Этот метод позволяет удалить существующее описание из системы.",
            parameters = {
                    @Parameter(name = "id", description = "ID описания, которое необходимо удалить")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Успешный ответ",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            )),
                    @ApiResponse(responseCode = "400", description = "Ошибка при удалении описания",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BaseResponse.class)
                            ))
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Описание удалено"));

        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}

