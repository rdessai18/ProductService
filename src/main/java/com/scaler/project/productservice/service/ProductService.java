package com.scaler.project.productservice.service;

import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.projections.ProductWithIdAndTitle;

import java.util.List;

public interface ProductService {
    Product getByProductId(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    ProductWithIdAndTitle getProductByIdAndTitle(Long id);

    Product updateProduct(Product product);

    void deleteProduct(Long id);
}
