package net.javaguides.Banking_app.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.Banking_app.Service.AccountService;
import net.javaguides.Banking_app.dto.AccountDto;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
     private AccountService accountservice;

	/**
	 * @param accountservice
	 */
    
	public AccountController(AccountService accountservice) {
		this.accountservice = accountservice;
	}
     
     //Add Account Rest API
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountservice.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AccountDto> getByAccountid(@PathVariable("id") int id){
		AccountDto Accountdto = accountservice.getAccountById(id);
		return ResponseEntity.ok(Accountdto);
		
		
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable int id, @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		AccountDto accountdto = accountservice.Deposit(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	
	
	// withdraw rest api
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable int id, @RequestBody Map<String,Double> request){
		Double amount = request.get("amount");
		AccountDto accountdto = accountservice.withdraw(id, amount);
		return ResponseEntity.ok(accountdto);
	}
	
	// Get All accounts rest api
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts = accountservice.getAllAccount();
		return ResponseEntity.ok(accounts);
		
	}
	// delete by id
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		accountservice.deleteAccount(id);
		return ResponseEntity.ok("Account deactivated");
	}
}
