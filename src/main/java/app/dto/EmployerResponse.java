package app.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployerResponse {
  private Long id;
  private String name;
  private String address;
  private Date createdDate;
  private Date lastModifiedDate;
}
