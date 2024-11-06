package com.ia03.controller;

import io.swagger.v3.oas.annotations.Operation;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class MainController {
  @Value("${api.endpoint}")
  private String apiEndpoint;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(tags = {"Main APIs"})
  public ResponseEntity<Map<String, Object>> healthCheck() {
    Map<String, Object> health = new HashMap<>();

    health.put("name", "ia04-be");
    health.put("version", "1.0.0");
    health.put("status", "active");
    health.put("health", "ok");
    health.put("author", "21120521 - Nguyen Phuc Phat");
    health.put("api-docs", String.format("%s/swagger-ui/index.html", apiEndpoint));

    return ResponseEntity.ok(health);
  }
}
