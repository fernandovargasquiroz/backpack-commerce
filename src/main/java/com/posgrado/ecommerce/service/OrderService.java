package com.posgrado.ecommerce.service;

import com.posgrado.ecommerce.dto.OrderDto;
import com.posgrado.ecommerce.entity.Order;
import java.util.UUID;

public interface OrderService {
  String create(OrderDto order);

  OrderDto getById(UUID id);
}
