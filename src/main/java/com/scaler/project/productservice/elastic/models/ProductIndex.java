package com.scaler.project.productservice.elastic.models;

import com.scaler.project.productservice.models.BaseModel;
import com.scaler.project.productservice.models.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class ProductIndex {
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String imageUrl;
    private int numberOfSales;
}
