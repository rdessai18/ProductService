package com.scaler.project.productservice.elastic.repository;

import com.scaler.project.productservice.elastic.models.ProductIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticProductIndexRepository extends ElasticsearchRepository<ProductIndex, Long> {

}
