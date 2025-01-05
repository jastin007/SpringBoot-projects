package net.javaguides.Banking_app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="Banking_app")
@Entity
public class Account {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
//	  @Column(name= "account_holder_name")
      private String accountholderName;
      private double balance;
      
      // getter and setter methods
      
      
      
      
	/**
	 * @param id
	 * @param accountholderName
	 * @param balance
	 */
	public Account(int id, String accountholderName, double balance) {
		this.id = id;
		this.accountholderName = accountholderName;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountholderName() {
		return accountholderName;
	}

	public void setAccountholderName(String accountholderName) {
		this.accountholderName = accountholderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account()
	{
		
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountholderName=" + accountholderName + ", balance=" + balance + "]";
	}
      
     
}
