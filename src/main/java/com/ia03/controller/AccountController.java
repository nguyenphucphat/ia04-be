package com.ia03.controller;

import com.ia03.projection.request.LoginRequest;
import com.ia03.projection.request.RegisterUserRequest;
import com.ia03.projection.response.BaseResponse;
import com.ia03.projection.response.LoginResponse;
import com.ia03.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {
  private final UserService userService;

  @PostMapping("/register")
  @Operation(tags = "Account APIs", summary = "Register a new user")
  @ResponseStatus(HttpStatus.CREATED)
  public BaseResponse<LoginResponse> register(@RequestBody @Valid RegisterUserRequest request) {
    return BaseResponse.of(userService.register(request));
  }

  @PostMapping("/login")
  @Operation(tags = "=Account APIs", summary = "Login a user")
  @ResponseStatus(HttpStatus.OK)
  public BaseResponse<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
    return BaseResponse.of(userService.login(request));
  }
}
