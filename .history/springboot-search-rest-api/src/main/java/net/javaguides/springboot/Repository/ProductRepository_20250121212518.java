package net.javaguides.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> searchProducts(String query);
}
