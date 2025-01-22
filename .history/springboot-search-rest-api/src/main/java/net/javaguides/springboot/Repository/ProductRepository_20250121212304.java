package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
