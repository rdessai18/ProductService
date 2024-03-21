package com.scaler.project.productservice.elastic.repository;

import com.scaler.project.productservice.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

}
