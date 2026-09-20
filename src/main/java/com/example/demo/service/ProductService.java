package com.example.demo.service;

import com.example.demo.dto.PageInfo;
import com.example.demo.dto.ProductInput;
import com.example.demo.dto.ProductPage;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
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
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAllByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public ProductPage search(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending());
        Page<Product> result;
        if (keyword == null || keyword.isBlank()) {
            result = productRepository.findAll(pageable);
        } else {
            result = productRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                    keyword, keyword, pageable);
        }
        return new ProductPage(result.getContent(),
                new PageInfo( (int) result.getTotalElements(), result.getTotalPages(),
                        result.getNumber(), result.getSize()));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(ProductInput input) {
        Category category = categoryRepository.findById(input.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found: " + input.getCategoryId()));
        Product p = new Product();
        map(input, p);
        p.setCategory(category);
        return productRepository.save(p);
    }

    public Product update(Long id, ProductInput input) {
        Product p = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
        map(input, p);
        if (input.getCategoryId() != null) {
            Category category = categoryRepository.findById(input.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found: " + input.getCategoryId()));
            p.setCategory(category);
        }
        return productRepository.save(p);
    }

    public Boolean delete(Long id) {
        if (!productRepository.existsById(id)) return false;
        productRepository.deleteById(id);
        return true;
    }

    private void map(ProductInput input, Product p) {
        p.setTitle(input.getTitle());
        p.setDescription(input.getDescription());
        p.setImages(input.getImages());
        p.setPrice(input.getPrice());
        p.setAmount(input.getAmount());
    }
}
