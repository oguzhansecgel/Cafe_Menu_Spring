package com.cafemmenu.Repositories;

import com.cafemmenu.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
