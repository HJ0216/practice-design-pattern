package org.example;

import java.time.LocalDate;
import org.example.builder.Address;
import org.example.builder.dto.CoworkerDTO;
import org.example.builder.dto.CoworkerDTOBuilder;
import org.example.builder.dto.FriendDTOBuilder;
import org.example.builder.dto.PersonDTO;
import org.example.builder.dto.FriendDTO;
import org.example.builder2.Cafe;
import org.example.builder2.dto.CafeDTO;

public class Main {

  public static void main(String[] args) {
    Address address = new Address("10000", "seoul", "seocho-gu");
    PersonDTO friend = new FriendDTO("kim", "kimi", LocalDate.of(1995, 2, 16), address);
    PersonDTO coworker = new CoworkerDTO("kim", "staff", LocalDate.of(1995, 2, 16), address);

    PersonDTO friendFromBuilder = new FriendDTOBuilder().name("kim")
                                                        .nickname("kimi")
                                                        .birthday(LocalDate.of(1995, 2, 16))
                                                        .address(address)
                                                        .build();

    PersonDTO coworkerFromBuilder = new CoworkerDTOBuilder().name("kim")
                                                            .position("staff")
                                                            .birthday(LocalDate.of(1995, 2, 16))
                                                            .address(address)
                                                            .build();

    CafeDTO cafeDto = CafeDTO.builder()
                          .name("starbucks")
                          .address(address)
                          .signature("americano")
                          .rating(5)
                          .build();

    Cafe cafe = new Cafe("two-some", new Address("12345", "seoul", "bangbae"), "milktea", 5);
    CafeDTO cafeDTOFromEntity = CafeDTO.toDTO(cafe);
  }
}