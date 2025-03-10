package org.example.builder2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.example.builder.Address;
import org.example.builder2.Cafe;

@Getter
@ToString
@AllArgsConstructor
public class CafeDTO {
  private String name;
  private String address;
  private String signature;
  private String rating;

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private String name;
    private String address;
    private String signature;
    private String rating;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder address(Address address) {
      this.address = "(" + address.getZipCode() + ") " + address.getState() + " " + address.getCity();
      return this;
    }

    public Builder signature(String signature) {
      this.signature = signature;
      return this;
    }

    public Builder rating(int rating) {
      this.rating = "★".repeat(rating);
      return this;
    }

    public CafeDTO build() {
      return new CafeDTO(name, address, signature, rating);
    }

  }

  public static CafeDTO toDTO(Cafe cafe) {
    return CafeDTO.builder()
                  .name(cafe.getName())
                  .address(cafe.getAddress())
                  .signature(cafe.getSignature())
                  .rating(cafe.getRating())
                  .build();
  }
}
