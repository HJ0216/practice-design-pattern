package org.example.builder2.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.example.builder.Address;
import org.example.builder2.Cafe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CafeDTOTest {

  @Test
  @DisplayName("Builder should create a valid CafeDTO")
  void builder_createCafeDTO() {
    // given
    String name = "ediya";
    Address address = new Address("12345", "seoul", "bangbae");
    String signature = "waffle";
    int rating = 5;

    // when
    CafeDTO dto = CafeDTO.builder()
                         .name(name)
                         .address(address)
                         .signature(signature)
                         .rating(rating)
                         .build();

    assertEquals(name, dto.getName());
    assertEquals("(12345) seoul bangbae", dto.getAddress());
    assertEquals(signature, dto.getSignature());
    assertEquals("★★★★★", dto.getRating());
  }

  @Test
  @DisplayName("toDTO should convert Cafe to CafeDTO correctly")
  void toDTO() {
    // given
    String name = "ediya";
    Address address = new Address("12345", "seoul", "bangbae");
    String signature = "waffle";
    int rating = 5;

    Cafe cafe = new Cafe(name, address, signature, rating);

    // when
    CafeDTO dto = CafeDTO.toDTO(cafe);

    // then
    assertEquals(name, dto.getName());
    assertEquals("(12345) seoul bangbae", dto.getAddress());
    assertEquals(signature, dto.getSignature());
    assertEquals("★★★★★", dto.getRating());
  }

  @ParameterizedTest
  @DisplayName("Rating should produce the correct number of stars")
  @ValueSource(ints = {1,2,3,4,5})
  void builder_rating_shouldProductCorrectStars(int rating) {
    // when
    CafeDTO dto = CafeDTO.builder()
                         .name("cafe")
                         .address(new Address("12345", "seoul", "bangbae"))
                         .signature("americono")
                         .rating(rating)
                         .build();

    // then
    assertEquals("★".repeat(rating), dto.getRating());
  }

  @Test
  @DisplayName("Builder should build object with minimal required fields")
  void builder_minimalFields() {
    // when
    CafeDTO dto = CafeDTO.builder()
                         .name("Cafe")
                         .address(new Address("12345", "seoul", "gangnam"))
                         .build();

    // then
    assertEquals("Cafe", dto.getName());
    assertEquals("(12345) seoul gangnam", dto.getAddress());
    assertNull(dto.getSignature());
    assertNull(dto.getRating());
  }

  @Test
  @DisplayName("Builder should handle null address properly")
  void builder_nullAddress_shouldThrowException() {
    // when
    Executable executable = () -> CafeDTO.builder()
                                         .name("Cafe")
                                         .address(null)
                                         .signature("latte")
                                         .rating(3)
                                         .build();

    // then
    assertThrows(NullPointerException.class, executable);
  }

}