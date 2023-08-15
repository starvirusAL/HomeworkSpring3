package app.serviceInterface;

import app.models.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    public void create(Customer customer);
    public List<Customer> findAll();
    public Customer getCustomerById(int id);


}
