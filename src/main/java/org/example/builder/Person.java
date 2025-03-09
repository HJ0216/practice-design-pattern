package org.example.builder;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
  private String name;
  private LocalDate birthday;
  private Address address;
}
