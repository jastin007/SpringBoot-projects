package net.javaguides.springboot.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.Entity.Product;
import net.javaguides.springboot.Service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public ResponseEntity<List<Product>> searchProducts(String name) {
        return ResponseEntity.ok(productService.searchProducts(name));
    }
}
