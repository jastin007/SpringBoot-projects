package net.javaguides.springboot;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.javaguides.springboot.Entity.Product;
import net.javaguides.springboot.Repository.ProductRepository;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        // create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setActive(true);
        product.setImageUrl("product1.png");

        // save product
        Product savedObject = productRepository.save(product);
        // display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());

    }

    @Test
    void updateUsingSaveMethod() {

        // find or retrieve an entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");
        // save updated entity
        productRepository.save(product);
    }

    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {
        // create product
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setActive(true);
        product.setSku("100ABCD");
        product.setImageUrl("product2.png");

        // create product
        Product product1 = new Product();
        product1.setName("product 3");
        product1.setDescription("product 2 description");
        product1.setActive(true);
        product1.setSku("100ABCD");
        product1.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product, product1));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);

    }

    @Test
    void deleteMethod() {
        // find an entity by id

        Long id = 2L;
        Product product = productRepository.findById(id).get();

        // delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod() {
        Long id = 9L;

        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}
