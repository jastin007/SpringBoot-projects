package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.Entity.Product;

public interface ProductService {
    List<Product> searchProducts(String query);
}
