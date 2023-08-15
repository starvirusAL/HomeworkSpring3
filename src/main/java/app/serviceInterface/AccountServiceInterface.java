package app.serviceInterface;

import app.models.Account;

import java.util.List;

public interface AccountServiceInterface {
    public void create(Account a);
    public Account getAccountById(int id);
    public List<Account> findAll();
    public void replenishTheBalance(Account account, double valueM);


}
