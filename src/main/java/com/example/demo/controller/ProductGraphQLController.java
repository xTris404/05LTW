package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductGraphQLController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // ===== Yêu cầu 1 =====
    @QueryMapping
    public List<Product> productsByPriceAsc() {
        return productService.findAllByPriceAsc();
    }

    // ===== Yêu cầu 2 =====
    @QueryMapping
    public List<Product> productsByCategory(@Argument Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @QueryMapping
    public List<Category> categories() {
        return categoryService.findAll();
    }

    // ===== Yêu cầu 3 - Product =====
    @QueryMapping
    public ProductPage products(@Argument int page, @Argument int size, @Argument String keyword) {
        return productService.search(page, size, keyword);
    }

    @QueryMapping
    public Optional<Product> productById(@Argument Long id) {
        return productService.findById(id);
    }

    @MutationMapping
    public Product createProduct(@Argument ProductInput input) {
        return productService.create(input);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument ProductInput input) {
        return productService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        return productService.delete(id);
    }

    // ===== Yêu cầu 3 - Category =====
    @QueryMapping
    public CategoryPage categoriesPage(@Argument int page, @Argument int size, @Argument String keyword) {
        return categoryService.search(page, size, keyword);
    }

    @QueryMapping
    public Optional<Category> categoryById(@Argument Long id) {
        return categoryService.findById(id);
    }

    @MutationMapping
    public Category createCategory(@Argument CategoryInput input) {
        return categoryService.create(input);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument CategoryInput input) {
        return categoryService.update(id, input);
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Long id) {
        return categoryService.delete(id);
    }
}
