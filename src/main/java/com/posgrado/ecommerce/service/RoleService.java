package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.RoleDto;
import com.posgrado.ecommerce.entity.Role;
import java.util.List;

public interface RoleService {
  Role getByName(String name);

  List<Role> getAll();

  boolean existRole(String name);

  Role create(RoleDto role);
}
