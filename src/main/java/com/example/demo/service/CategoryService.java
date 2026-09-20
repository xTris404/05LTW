package com.example.demo.service;

import com.example.demo.dto.CategoryInput;
import com.example.demo.dto.CategoryPage;
import com.example.demo.dto.PageInfo;
import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryPage search(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<Category> result;
        if (keyword == null || keyword.isBlank()) {
            result = categoryRepository.findAll(pageable);
        } else {
            result = categoryRepository.findByNameContainingIgnoreCase(keyword, pageable);
        }
        return new CategoryPage(result.getContent(),
                new PageInfo( (int) result.getTotalElements(), result.getTotalPages(),
                        result.getNumber(), result.getSize()));
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(CategoryInput input) {
        Category c = new Category();
        c.setName(input.getName());
        c.setDescription(input.getDescription());
        return categoryRepository.save(c);
    }

    public Category update(Long id, CategoryInput input) {
        Category c = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found: " + id));
        c.setName(input.getName());
        c.setDescription(input.getDescription());
        return categoryRepository.save(c);
    }

    public Boolean delete(Long id) {
        if (!categoryRepository.existsById(id)) return false;
        categoryRepository.deleteById(id);
        return true;
    }
}
