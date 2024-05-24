package com.example.myWarehouse.controller;

import com.example.myWarehouse.entity.AuthorizationEntity;
import com.example.myWarehouse.service.AuthorizationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/authorization")
@Tag(name = "Регистрация")
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Operation(summary = "Зарегистрировать нового пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Пользователь зарегистрирован успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorizationEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Неверное тело запроса")
    })
    @PostMapping("/register")
    public ResponseEntity<AuthorizationEntity> registerUser(@RequestBody AuthorizationEntity user) {
        AuthorizationEntity registeredUser = authorizationService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

    @Operation(summary = "Войти в систему")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь вошел в систему успешно",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthorizationEntity.class))}),
            @ApiResponse(responseCode = "401", description = "Неверный логин или пароль")
    })
    @PostMapping("/entrance")
    public ResponseEntity<AuthorizationEntity> loginUser(@RequestBody AuthorizationEntity user) {
        AuthorizationEntity loggedInUser = authorizationService.entranceUser(user.getLogin(), user.getPassword());
        return ResponseEntity.ok(loggedInUser);
    }
}



