package com.scaler.project.productservice.controller;

import com.scaler.project.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Mock
    final ProductService service;

    @InjectMocks
    final ProductController controller;

    ProductControllerTest(@Qualifier("fakeStoreProductService") ProductService service, ProductController controller) {
        this.service = service;
        this.controller = controller;
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void getSingleProduct() {
    }

    @Test
    void createProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}