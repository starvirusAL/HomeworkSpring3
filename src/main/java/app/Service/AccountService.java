package app.Service;

import app.models.Account;
import app.repo.AccountRepo;
import app.serviceInterface.AccountServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface {
    private final AccountRepo accountRepo;

    public void create(Account a) {
        accountRepo.save(a);
    }
    public Account getAccountById(int id){
        return accountRepo.getAccountById(id);
    }
    public List<Account> findAll(){
        return accountRepo.findAll();
    }

    public void replenishTheBalance(Account account, double valueM) {
        account.setBalance(account.getBalance() + valueM);

    }
    public boolean withdrawBalance(Account account, double valueM) {
        if (account.getBalance() >= valueM) {
            account.setBalance(account.getBalance() - valueM);
            return true;
        } else {
            return false;
        }

    }
    public boolean transferMoney(Account account1, Account account2, double valueM) {
        if (account1.getBalance() >= account2.getBalance()) {
            account2.setBalance(account2.getBalance() + valueM);
            account1.setBalance(account1.getBalance() - valueM);
            return true;
        } else {
            return false;
        }

    }
    public void delete(Account account){
        accountRepo.delete(account);
    }




}
