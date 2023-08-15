package app.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Data
public class CustomerRequest {
  @NotNull
  @Size(min = 2, message = "user name should have at least 2 characters")
  private String name;
  @Email
  private String email;
  @NotNull
  @Range(min =18,message = "User must be at least 18 years old")
  private Integer age;
  @Pattern(regexp = "^((\\+?380)([0-9]{9}))$",message = "Tel number must look like this example +38096586033")
  @NotBlank
  private String phoneNumber;
}
