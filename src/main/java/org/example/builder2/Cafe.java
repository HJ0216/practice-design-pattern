package org.example.builder2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.builder.Address;

@Getter
@AllArgsConstructor
public class Cafe {
  private String name;
  private Address address;
  private String signature;
  private int rating;

}
