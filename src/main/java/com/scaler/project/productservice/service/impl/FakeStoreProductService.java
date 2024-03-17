package com.scaler.project.productservice.service.impl;

import com.scaler.project.productservice.dto.FakeStoreProductDto;
import com.scaler.project.productservice.exception.ProductNotFoundException;
import com.scaler.project.productservice.models.Category;
import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.projections.ProductWithIdAndTitle;
import com.scaler.project.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.scaler.project.productservice.constant.FakeStoreURI.*;

@Service
@Primary
public class FakeStoreProductService implements ProductService {
    private final RestTemplate restTemplate;

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    public Product getByProductId(Long id) throws ProductNotFoundException {
        // check in Cache
        Product product = null;
        product = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+id);
        String uri = GET_PRODUCT_URI + "/" + id;
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(uri, FakeStoreProductDto.class);
        if(null == fakeStoreProductDto){
            throw new ProductNotFoundException("Product with Id: "+ id + " not found.");
        }
        product = convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+id, product);
        return product;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(Long.valueOf(fakeStoreProductDto.getId()));
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());
        product.setDescription(fakeStoreProductDto.getDescription());
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

    @Override
    public Product createProduct(Product product) {
        Product newProduct = restTemplate.postForObject(POST_PRODUCT_URI, product, Product.class);
        return newProduct;
    }

    @Override
    public ProductWithIdAndTitle getProductByIdAndTitle(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        Long id = product.getId();
        String uri = PUT_PRODUCT_URI + id;
        //restTemplate.put(uri, product);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, Product.class);
        ResponseExtractor<ResponseEntity<Product>> responseExtractor = restTemplate.responseEntityExtractor(Product.class);
        ResponseEntity<Product> productResponseEntity = restTemplate.execute(uri, HttpMethod.PUT, requestCallback, responseExtractor);
        Product updatedProduct = productResponseEntity.getBody();
        return updatedProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        String url = DELETE_PRODUCT_URI + id;
        restTemplate.delete(url);
    }
}
