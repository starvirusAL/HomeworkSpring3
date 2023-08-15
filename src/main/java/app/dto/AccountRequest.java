package app.dto;

import homework1.models.Currency;
import lombok.Data;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@Data
public class AccountRequest {
  @NotNull
  private String number;
  @NotNull
  private Currency currency;
  @Negative
  private Double balance;
}
