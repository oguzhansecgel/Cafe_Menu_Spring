package com.cafemmenu.Services.CategoryServices;

import com.cafemmenu.Entities.Category;
import com.cafemmenu.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<Category> getByIdCategory(Long id) {
         Category category = categoryRepository.findById(id).orElse(null);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> createCategory(Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Category> deleteCategory(Long id) {
        Optional<Category> hasCategory = categoryRepository.findById(id);
        if(hasCategory !=null)
        {
            categoryRepository.deleteById(id);
            return new ResponseEntity<Category>(HttpStatus.OK);
        }
        return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Category> updateCategory(Category category) {
        Optional<Category> hasCategory = categoryRepository.findById(category.getId());
        if(hasCategory.isPresent())
        {
            categoryRepository.saveAndFlush(category);
            return new ResponseEntity<Category>(category,HttpStatus.OK);
        }
        return new ResponseEntity<Category>(category,HttpStatus.BAD_REQUEST);
    }
}
