package net.javaguides.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.javaguides.springboot.Entity.Product;
import net.javaguides.springboot.Repository.ProductRepository;

@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod() {
        Product product = productRepository.findById(8L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("product 2", "product 2 Description");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod() {
        Product products = productRepository.findDistinctByName("product 2");
        System.out.println(products.getId());
        System.out.println(products.getName());
        System.out.println(products.getDescription());
    }

    @Test
    void findByNameContainingMethod() {
        List<Product> product = productRepository.findByNameContaining("product 3");
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod() {
        List<Product> product = productRepository.findByNameLike("product 2");
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameInMethod() {
        List<Product> product = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod() {
        List<Product> product = productRepository.findFirst2ByOrderByNameAsc();
        product.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
