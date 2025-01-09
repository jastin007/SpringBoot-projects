package net.javaguides.Banking_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.Banking_app.Entity.Account;

//below is used to perform crud database operations
public interface AccountRepository extends JpaRepository<Account,Integer>{
         
}
