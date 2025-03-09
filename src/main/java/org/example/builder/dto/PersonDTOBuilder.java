package org.example.builder.dto;

import java.time.LocalDate;
import org.example.builder.Address;

public interface PersonDTOBuilder<T extends PersonDTOBuilder<T>> {
  T name(String name);
  T birthday(LocalDate birthday);
  T address(Address address);

  PersonDTO build();
}
