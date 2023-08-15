package app.Service;

import app.models.Customer;
import app.models.Employer;
import app.repo.EmployerRepo;
import app.serviceInterface.EmployerServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerService implements EmployerServiceInterface {

    private final EmployerRepo employerRepo;

    public void create(Employer e) {
        employerRepo.save(e);
    }


    public List<Employer> findAll() {
        return employerRepo.findAll();
    }


    public Employer getEmployerById(int id) {
        return employerRepo.getEmployerById(id);
    }

    public  void delete(Employer e){
        employerRepo.delete(e);
    }
}
