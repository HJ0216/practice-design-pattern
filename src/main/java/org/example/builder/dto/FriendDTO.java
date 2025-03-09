package org.example.builder.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.builder.Address;

@Getter
@AllArgsConstructor
@ToString
public class FriendDTO implements PersonDTO {
  private String name;
  private String nickname;
  private LocalDate birthday;
  private Address address;

}
