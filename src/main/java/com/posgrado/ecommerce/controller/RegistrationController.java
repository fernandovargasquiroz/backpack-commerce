package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.OrderItemDto;
import com.posgrado.ecommerce.dto.RegistrationRequest;
import com.posgrado.ecommerce.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationController {

  private RegistrationService registrationService;

  @PostMapping
  public ResponseEntity<String> register(@RequestBody  RegistrationRequest dto) {
    String message = registrationService.register(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

}
