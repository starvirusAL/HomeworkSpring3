package app.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EmployerRequest {
  @NotNull
  @Size(min = 3, message = "company name should have at least 3 characters")
  private String name;
  @NotNull
  @Size(min = 3, message = "company location should have at least 3 characters")
  private String address;
  }
