package app.dto;


import app.models.Account;
import app.models.Employer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class CustomerResponseDto {
  private Long id;
  private String name;
  private String email;
  private Integer age;
  private String phoneNumber;
  private List<Account> accounts;
  private Set<Employer> employers;

}
