package com.cafemmenu.Controller;

import com.cafemmenu.Dtos.CategoryDto.CreateCategoryDto;
import com.cafemmenu.Entities.Category;
import com.cafemmenu.Services.CategoryServices.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;
    private final ModelMapper modelMapper;

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
    public CreateCategoryDto createCategory(@RequestBody CreateCategoryDto createCategoryDto)
    {
        Category category = modelMapper.map(createCategoryDto,Category.class);
        return createCategoryDto;
    }
    @DeleteMapping("/deleteCategory")
    public ResponseEntity<Category> deleteCategory(@RequestParam Long id){return categoryService.deleteCategory(id);}
    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category){return categoryService.updateCategory(category);}
}
