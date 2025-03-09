package org.example.builder.dto;

import java.time.LocalDate;
import org.example.builder.Address;

public class CoworkerDTOBuilder implements PersonDTOBuilder<CoworkerDTOBuilder>{
  private String name;
  private String position;
  private LocalDate birthday;
  private Address address;

  @Override
  public CoworkerDTOBuilder name(String name) {
    this.name = name;
    return this;
  }

  public CoworkerDTOBuilder position(String position) {
    this.position = position;
    return this;
  }

  @Override
  public CoworkerDTOBuilder birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  @Override
  public CoworkerDTOBuilder address(Address address) {
    this.address = address;
    return this;
  }

  @Override
  public PersonDTO build() {
    return new CoworkerDTO(name, position, birthday, address);
  }
}
