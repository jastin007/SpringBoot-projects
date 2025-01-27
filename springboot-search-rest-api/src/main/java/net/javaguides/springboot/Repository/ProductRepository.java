package net.javaguides.springboot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " + "p.name LIKE CONCAT('%',:query,'%')" +
            "Or p.description LIKE CONCAT('%', :query, '%')")
    List<Product> searchProducts(String query);

    public Product findByName(String name);

    // Optional<Product> findById(Long id);
    Optional<Product> findById(Long id);

    List<Product> findByNameOrDescription(String name, String description);

    Product findDistinctByName(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameIn(List<String> name);

    List<Product> findFirst2ByOrderByNameAsc();

}
