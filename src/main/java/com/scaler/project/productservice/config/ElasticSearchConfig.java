package com.scaler.project.productservice.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestClientSsl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.scaler.project.productservice.elastic")
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    @Override
    @Bean
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
    }

}
