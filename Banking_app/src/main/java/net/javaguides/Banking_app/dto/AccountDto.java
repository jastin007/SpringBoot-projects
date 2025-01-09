package net.javaguides.Banking_app.dto;

public class AccountDto {
     private int id;
     private String accountHolderName;
     private double balance;
	/**
	 * @param id
	 * @param accountHolderName
	 * @param balance
	 */
	public AccountDto(int id, String accountHolderName, double balance) {
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
     
     
     
     
}
