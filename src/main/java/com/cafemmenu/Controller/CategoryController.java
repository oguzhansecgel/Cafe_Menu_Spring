package com.cafemmenu.Controller;

import com.cafemmenu.Entities.About;
import com.cafemmenu.Entities.Category;
import com.cafemmenu.Services.CategoryServices.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @GetMapping("getALL")
    public List<Category> getAllCategory()
    {
        return categoryService.getAllCategory();
    }
    @GetMapping("getByIdCategory")
    public ResponseEntity<Category> getByIdCategory(Long id)
    {
        return categoryService.getByIdCategory(id);
    }
    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category)
    {
        return categoryService.createCategory(category);
    }
    @DeleteMapping("/deleteCategory")
    public ResponseEntity<Category> deleteCategory(@RequestParam Long id){return categoryService.deleteCategory(id);}
    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){return categoryService.updateCategory(category);}
}
