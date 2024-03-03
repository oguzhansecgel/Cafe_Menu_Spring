package com.cafemmenu.Controller;

import com.cafemmenu.Dtos.ProductDto.CreateProductDto;
import com.cafemmenu.Entities.Product;
import com.cafemmenu.Services.ProductServices.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;

    @GetMapping("/getAll")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/GetByIdProduct")
    public ResponseEntity<Product> getByIdProduct(@RequestParam Long id) {
        return productService.getByIdProduct(id);

    }
    @GetMapping("category/{categoryId}")
    public List<Product> categoryId(@RequestParam Long categoryId)
    {
        return productService.getProductsByCategoryId(categoryId);
    }
    @GetMapping("categoryName")
    public List<String> categoryName()
    {
        return productService.getProductWithCategoryName();
    }
    @GetMapping("price")
    public List<Product> getPrice5Asc()
    {
        return productService.getProductFindTop5ByOrderByPriceAsc();
    }
    @PostMapping("/CreateProduct")
    public CreateProductDto createProduct(@RequestBody CreateProductDto createProductDto)
    {
        Product product = modelMapper.map(createProductDto,Product.class);
        return createProductDto;
    }
    @PutMapping("/UpdateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }
    @DeleteMapping("/DeleteProduct")
    public ResponseEntity<Product> deleteProduct(@RequestParam Long id)
    {
        return productService.deleteProduct(id);
    }
}
