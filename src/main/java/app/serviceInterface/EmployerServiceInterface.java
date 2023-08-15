package app.serviceInterface;

import app.models.Customer;
import app.models.Employer;

import java.util.List;


public interface EmployerServiceInterface {
    public void create(Employer employer);
    public List<Employer> findAll();
    public Employer getEmployerById(int id);

}
