package net.javaguides.Banking_app.mapper;

import net.javaguides.Banking_app.Entity.Account;
import net.javaguides.Banking_app.dto.AccountDto;

public class AccountManager {
	
	public static Account mapToAccount(AccountDto accountDto) {
	      Account account = new Account(
	    		  accountDto.getId(),
	    		  accountDto.getAccountHolderName(),
	    		  accountDto.getBalance()
	    		  );
	      return account;
		
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountholderName(),
				account.getBalance()
				);
		return accountDto;
	}
    
}
