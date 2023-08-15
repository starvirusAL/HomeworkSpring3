package app.models;

import app.enums.Currency;
import lombok.Data;

@Data
public class InputItems {
  String name;

  String address;
  String email;
  Integer age;

  Double valueM;

  int idCustomer;
  int idAccount;

  int idCustomer2;
  int idAccount2;
  Currency inputCurrency;
  int checkPage;

}
