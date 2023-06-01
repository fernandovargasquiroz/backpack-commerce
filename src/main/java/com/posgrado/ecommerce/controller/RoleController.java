package com.posgrado.ecommerce.controller;

import com.posgrado.ecommerce.dto.ConflictResponseDto;
import com.posgrado.ecommerce.dto.ProductDto;
import com.posgrado.ecommerce.dto.RoleDto;
import com.posgrado.ecommerce.entity.Product;
import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.exception.RoleExist;
import com.posgrado.ecommerce.service.RoleService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name) {
    Role roleFound = roleService.getByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(roleFound);
  }

  @GetMapping
  public ResponseEntity<List<Role>> getAll() {
    List<Role> roles = roleService.getAll();
    return ResponseEntity.ok(roles);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody RoleDto dto) {
    boolean existRole = roleService.existRole(dto.getName());
    if (existRole) {
      ConflictResponseDto conflictResponse = new ConflictResponseDto();
      conflictResponse.setStatus(HttpStatus.CONFLICT.toString());
      conflictResponse.setError("Role Name Already Exists");
      conflictResponse.setMessage(new RoleExist(dto.getName()).getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictResponse);
    }

    Role roleSaved = roleService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
  }
}
