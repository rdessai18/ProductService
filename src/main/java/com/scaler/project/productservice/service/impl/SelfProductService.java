package com.scaler.project.productservice.service.impl;

import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.repositories.ProductRepository;
import com.scaler.project.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product getByProductId(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
