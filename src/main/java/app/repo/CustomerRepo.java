package app.repo;

import app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    public Customer getCustomerById(int id);

    public void delete(Customer customer);
}
