# Design Patterns

## Builder Pattern
* **정의**: 복잡한 객체들을 단계별로 생성할 수 있도록 하는 생성 디자인 패턴
* **장점**: 선택적 매개변수 활용 가능(필수 필드만 설정하고, 필요한 필드만 추가 가능), 객체의 불변성이 유지되어 멀티 쓰레드 환경에서도 안전
* **단점**: 빌더 객체를 생성하는 과정이 추가되므로, 단순 객체 생성보다 메모리 사용이 증가할 수 있음
```java
// Builder Pattern 예제

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
      this.address = "(" + address.getZipCode() + ") " + address.getCity() + " " + address.getState();
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
```

```java
// 사용 예제

CafeDTO cafeDTOFromBuilder = CafeDTO.builder()
                                    .name("starbucks")
                                    .address(address)
                                    .signature("americano")
                                    .rating(5)
                                    .build();

Cafe cafe = new Cafe("two-some", new Address("12345", "seoul", "bangbae"), "milktea", 5);
CafeDTO cafeDTOFromEntity = CafeDTO.toDTO(cafe);
```
