package com.posgrado.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConflictResponseDto {
  private String status;
  private String error;
  private String message;
}
