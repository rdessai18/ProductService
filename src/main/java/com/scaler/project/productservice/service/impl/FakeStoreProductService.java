package com.scaler.project.productservice.service.impl;

import com.scaler.project.productservice.constant.FakeStoreURI;
import com.scaler.project.productservice.dto.FakeStoreProductDto;
import com.scaler.project.productservice.dto.Rating;
import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Category;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

import static com.scaler.project.productservice.constant.FakeStoreURI.GET_PRODUCT_URI;

@Service
@Primary
public class FakeStoreProductService implements ProductService {
    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getByProductId(Long id) throws ProductNotFoundException {
        String uri = GET_PRODUCT_URI + "/" + id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(uri, FakeStoreProductDto.class);
        if(null == fakeStoreProductDto){
            throw new ProductNotFoundException("Product with Id: "+ id + " not found.");
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(Long.valueOf(fakeStoreProductDto.getId()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    public List<Product> getAllProducts() {
        String uri = GET_PRODUCT_URI;
        FakeStoreProductDto[] fakeStoreProductDtoList = restTemplate.getForObject(uri, FakeStoreProductDto[].class);
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto dto: fakeStoreProductDtoList){
            productList.add(convertFakeStoreProductDtoToProduct(dto));
        }
        System.out.println(productList);
        return  productList;
    }
}
