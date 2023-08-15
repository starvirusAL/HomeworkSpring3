package app.repo;

import app.models.Account;
import app.models.Customer;
import app.models.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepo extends JpaRepository<Employer, Integer>{

    public Employer getEmployerById(int id);

    public void delete(Employer e);
}
