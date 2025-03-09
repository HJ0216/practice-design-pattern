package org.example.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {
  private String zipCode;
  private String state; // 도, 특별시
  private String city; // 시,구
}
