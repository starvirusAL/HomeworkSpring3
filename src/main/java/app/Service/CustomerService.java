package app.Service;

import app.models.Account;
import app.models.Customer;
import app.repo.AccountRepo;
import app.repo.CustomerRepo;
import app.serviceInterface.CustomerServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerServiceInterface {
    private final CustomerRepo customerRepo;

    private final AccountRepo accountRepo;

    public void create(Customer c) {
        customerRepo.save(c);
    }
    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(int id){
        return customerRepo.getCustomerById(id);
    }

    public void delete(Customer customer){
        customerRepo.delete(customer);
    }

    public void  refactorCustomer(Customer customer, String name, String email, int age)
    {
        customer.setEmail(email);
        customer.setAge(age);
        customer.setName(name);
    }
    public void accountAdd(Account a){

    }
}
