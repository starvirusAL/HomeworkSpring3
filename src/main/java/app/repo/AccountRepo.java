package app.repo;

import app.models.Account;
import app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    public Account getAccountById(int id);

    public void delete(Account account);
}
