package com.cafemmenu.Services.CategoryServices;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Entities.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public ResponseEntity<Category> getByIdCategory(Long id);
    public ResponseEntity<Category> createCategory(Category category);
    public ResponseEntity<Category> deleteCategory(Long id);
    public ResponseEntity<Category> updateCategory(Category category);
}
