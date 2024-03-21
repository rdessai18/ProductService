package com.scaler.project.productservice.elastic.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.scaler.project.productservice.models.Product;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

@Service
public class ElasticService {

    private final ElasticsearchOperations elasticsearchOperations;
    private final ElasticsearchClient elasticsearchClient;

    public ElasticService(ElasticsearchOperations elasticsearchOperations, ElasticsearchClient elasticsearchClient) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.elasticsearchClient = elasticsearchClient;
    }

    public Long save(Product product) {
        Product savedEntity = elasticsearchOperations.save(product);
        return savedEntity.getId();
    }

    public Product findById(Long id) {
        return elasticsearchOperations.get(id.toString(), Product.class);
    }
}
