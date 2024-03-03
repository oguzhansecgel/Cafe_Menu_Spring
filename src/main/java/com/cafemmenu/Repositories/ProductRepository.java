package com.cafemmenu.Repositories;

import com.cafemmenu.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategoryId(Long categoryId);

    @Override
    boolean existsById(Long id);


    @Query("SELECT DISTINCT p.category.categoryName FROM Product p")
    List<String> findProductCategories();
    @Query("SELECT MAX(p.price) FROM Product p")
    BigDecimal findMaxPrice();
    List<Product> findTop5ByOrderByPriceAsc();

}