package com.scaler.project.productservice.service.impl;

import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Category;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.projections.ProductWithIdAndTitle;
import com.scaler.project.productservice.repositories.CategoryRepository;
import com.scaler.project.productservice.repositories.ProductRepository;
import com.scaler.project.productservice.service.ProductService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Product getByProductId(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        if(null == product.getCategory().getId()){
            Category category = new Category();
            category.setName(product.getCategory().getName());
            category = categoryRepository.save(category);
            product.getCategory().setId(category.getId());
        }
        return productRepository.save(product);
    }

    @Override
    public ProductWithIdAndTitle getProductByIdAndTitle(Long id){
        ProductWithIdAndTitle productWithIdAndTitle =  productRepository.findProductWithIdAndTitle(id);
        return productWithIdAndTitle;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
