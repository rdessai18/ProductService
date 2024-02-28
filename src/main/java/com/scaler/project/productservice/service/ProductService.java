package com.scaler.project.productservice.service;

import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getByProductId(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();
}
