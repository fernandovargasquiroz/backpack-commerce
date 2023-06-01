package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.ProductDto;
import com.posgrado.ecommerce.dto.RoleDto;
import com.posgrado.ecommerce.entity.Category;
import com.posgrado.ecommerce.entity.Product;
import com.posgrado.ecommerce.entity.Role;
import com.posgrado.ecommerce.exception.EmailAlreadyTaken;
import com.posgrado.ecommerce.exception.EntityNotFoundException;
import com.posgrado.ecommerce.exception.RoleExist;
import com.posgrado.ecommerce.repository.RoleRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

  private RoleRepository roleRepository;

  @Override
  public Role getByName(String name) {
    return roleRepository.findByName(name)
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
  }

  @Override
  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  @Override
  public boolean existRole(String name) {
    return roleRepository.findByName(name).isPresent();
  }

  @Override
  public Role create(RoleDto dto) {
    Role role = new Role();
    role.setName(dto.getName());
    role.setDescription(dto.getDescription());
    return roleRepository.save(role);
  }


}
