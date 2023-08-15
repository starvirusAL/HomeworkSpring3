package app.dto;



import app.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper extends MapperFacade<Customer, CustomerResponseDto> {
    public CustomerMapper(){super(Customer.class , CustomerResponseDto.class); }
}
