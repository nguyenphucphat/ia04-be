package com.ia03.controller;

import com.ia03.annotation.IsAuthenticated;
import com.ia03.projection.response.BaseResponse;
import com.ia03.projection.response.UserResponse;
import com.ia03.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/get-me")
  @Operation(tags = "User", summary = "Get the current user")
  @ResponseStatus(HttpStatus.OK)
  @IsAuthenticated
  public BaseResponse<UserResponse> getMe() {
    return BaseResponse.of(userService.getMe());
  }

  @GetMapping()
  @Operation(tags = "User APIs", summary = "Get all users")
  @ResponseStatus(HttpStatus.OK)
  public BaseResponse<List<UserResponse>> getAllUsers() {
    return BaseResponse.of(userService.getAllUsers());
  }

  @DeleteMapping("/{id}")
  @Operation(tags = "User APIs", summary = "Delete a user")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public BaseResponse<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);

    return BaseResponse.ok();
  }
}
