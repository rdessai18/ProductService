package com.scaler.project.productservice.controller;

import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.service.ProductService;
import com.scaler.project.productservice.service.impl.FakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService fakeStoreProductService;

    @Autowired
    public ProductController(FakeStoreProductService fakeStoreProductService) {
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return fakeStoreProductService.getAllProducts();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        //return new ResponseEntity<>(fakeStoreProductService.getByProductId(id), HttpStatus.OK);
        Product product = fakeStoreProductService.getByProductId(id);
        if (null == product) {
            throw new ProductNotFoundException("Product with Id: " + id + " not found.");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable("id") Long id) {
        return new Product();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
    }
}
