package net.javaguides.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " + "p.name LIKE CONCAT('%',:query,'%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProduct(String query);
}
