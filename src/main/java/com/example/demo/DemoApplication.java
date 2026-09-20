package com.example.demo;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(CategoryRepository categoryRepo, ProductRepository productRepo) {
        return args -> {
            if (categoryRepo.count() == 0) {
                Category laptop = categoryRepo.save(new Category("Laptop", "Máy tính xách tay"));
                Category phone = categoryRepo.save(new Category("Smartphone", "Điện thoại thông minh"));
                Category appliance = categoryRepo.save(new Category("Gia dụng", "Thiết bị gia dụng"));

                productRepo.save(new Product("Laptop IBM W540", "Laptop 1", "laptop1.jpg", 1200.0, 10, laptop));
                productRepo.save(new Product("Laptop Asus 334", "Laptop 2", "laptop2.jpg", 950.0, 20, laptop));
                productRepo.save(new Product("iPhone 6s", "Phone 1", "phone1.jpg", 450.0, 15, phone));
                productRepo.save(new Product("Samsung S8", "Phone 2", "phone2.jpg", 550.0, 12, phone));
                productRepo.save(new Product("Máy giặt LG 610", "Máy giặt", "washer.jpg", 320.0, 5, appliance));
                productRepo.save(new Product("MacBook Pro M2", "Laptop cao cấp", "macbook.jpg", 1899.0, 8, laptop));
                productRepo.save(new Product("Xiaomi Redmi Note", "Phone giá rẻ", "xiaomi.jpg", 199.0, 30, phone));
            }
        };
    }
}
