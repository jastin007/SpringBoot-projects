package net.javaguides.Banking_app.Service.Imlp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.Banking_app.Entity.Account;
import net.javaguides.Banking_app.Repository.AccountRepository;
import net.javaguides.Banking_app.Service.AccountService;
import net.javaguides.Banking_app.dto.AccountDto;
import net.javaguides.Banking_app.mapper.AccountManager;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepository accountRepository;
	
	
	
	/**
	 * @param accountRepository
	 */
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}



	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		// TODO Auto-generated method stub
		Account account = AccountManager.mapToAccount(accountdto);
		Account savedAccount = accountRepository.save(account);
		return AccountManager.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto getAccountById(int id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
		Account savedAccount = accountRepository.save(account);
		return AccountManager.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto Deposit(int id, double amount) {
		// TODO Auto-generated method stub
		
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
        double total = account.getBalance()+ amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
         return AccountManager.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(int id, double amount) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exists"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("Insufficient");
		}
		double total = account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return AccountManager.mapToAccountDto(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccount() {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findAll();
		return accounts.stream().map((account)-> AccountManager.mapToAccountDto(account)).collect(Collectors.toList());
		
	}



	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exists"));
		accountRepository.deleteById(id);
	}
   
	
	
	
}
