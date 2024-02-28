package com.scaler.project.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    private Integer id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    private Rating rating;
}
