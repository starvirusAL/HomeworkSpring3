package app.dto;

import app.enums.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {
  private Long id;
  private String number;
  private Currency currency;
  private Double balance;
  LocalDateTime createdDateTime;

  @JsonProperty("customer")
  CustomerResponseDto customerResponseDto;
}
