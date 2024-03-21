package com.scaler.project.productservice.elastic.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.scaler.project.productservice.elastic.models.ProductIndex;
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

    public Long save(ProductIndex productIndex) {
        ProductIndex savedEntity = elasticsearchOperations.save(productIndex);
        return savedEntity.getId();
    }

    public ProductIndex findById(Long id) {
        return elasticsearchOperations.get(id.toString(), ProductIndex.class);
    }
}
