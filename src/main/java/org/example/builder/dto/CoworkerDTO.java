package org.example.builder.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.builder.Address;

@Getter
@AllArgsConstructor
@ToString
public class CoworkerDTO implements PersonDTO{
  private String name;
  private String position;
  private LocalDate birthday;
  private Address address;

}
