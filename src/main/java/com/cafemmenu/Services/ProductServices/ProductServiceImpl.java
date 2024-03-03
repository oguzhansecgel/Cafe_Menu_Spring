package com.cafemmenu.Services.ProductServices;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Entities.Product;
import com.cafemmenu.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<String> getProductWithCategoryName() {
        return productRepository.findProductCategories();
    }

    @Override
    public List<Product> getProductFindTop5ByOrderByPriceAsc() {
        return productRepository.findTop5ByOrderByPriceAsc();
    }


    @Override
    public ResponseEntity<Product> getByIdProduct(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> createProduct(Product product) {
        productRepository.save(product);
        return new ResponseEntity<Product>(product,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
        boolean hasProduct = productRepository.existsById(id);
        if (hasProduct)
        {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product product) {
        Optional<Product> hasProduct = productRepository.findById(product.getId());
        if(hasProduct.isPresent())
        {
            productRepository.saveAndFlush(product);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
