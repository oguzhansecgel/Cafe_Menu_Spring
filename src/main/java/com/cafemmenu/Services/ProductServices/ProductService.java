package com.cafemmenu.Services.ProductServices;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Entities.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public List<Product> getProductsByCategoryId(Long categoryId);
    public List<String> getProductWithCategoryName();
    public List<Product> getProductFindTop5ByOrderByPriceAsc();
    public ResponseEntity<Product> getByIdProduct(Long id);
    public ResponseEntity<Product> createProduct(Product product);
    public ResponseEntity<Product> deleteProduct(Long id);
    public ResponseEntity<Product> updateProduct(Product product);
}
