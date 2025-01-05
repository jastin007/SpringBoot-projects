package net.javaguides.Banking_app.Service;

import java.util.List;

import net.javaguides.Banking_app.Entity.Account;
import net.javaguides.Banking_app.dto.AccountDto;

public interface AccountService {
     AccountDto createAccount(AccountDto account);
     
     AccountDto  getAccountById(int id);
     
     AccountDto Deposit(int id , double amount);
     
     AccountDto withdraw(int id , double amount);
     
     List<AccountDto> getAllAccount();
     
     void deleteAccount(int id);
     
}
