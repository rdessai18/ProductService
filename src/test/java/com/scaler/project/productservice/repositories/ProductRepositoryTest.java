package com.scaler.project.productservice.repositories;

import com.scaler.project.productservice.projections.ProductWithIdAndTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findProductWithIdAndTitle() {
        ProductWithIdAndTitle productWithIdAndTitle = productRepository.findProductWithIdAndTitle(2L);
        System.out.println(productWithIdAndTitle.getId());
        System.out.println(productWithIdAndTitle.getTitle());
    }
}