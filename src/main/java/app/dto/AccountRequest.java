package app.dto;


import app.enums.Currency;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Negative;


@Data
public class AccountRequest {
  @NotNull
  private String number;
  @NotNull
  private Currency currency;
  @Negative
  private Double balance;
}
