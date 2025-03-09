package org.example.builder.dto;

import java.time.LocalDate;
import org.example.builder.Address;

public interface PersonDTO {
  String getName();
  LocalDate getBirthday();
  Address getAddress();

}