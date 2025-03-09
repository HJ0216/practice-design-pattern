package org.example.builder.dto;

import java.time.LocalDate;
import org.example.builder.Address;

public class FriendDTOBuilder implements PersonDTOBuilder<FriendDTOBuilder> {
  private String name;
  private String nickname;
  private LocalDate birthday;
  private Address address;

  @Override
  public FriendDTOBuilder name(String name) {
    this.name = name;
    return this;
  }

  public FriendDTOBuilder nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  @Override
  public FriendDTOBuilder birthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  @Override
  public FriendDTOBuilder address(Address address) {
    this.address = address;
    return this;
  }

  @Override
  public PersonDTO build() {
    return new FriendDTO(name, nickname, birthday, address);
  }
}
