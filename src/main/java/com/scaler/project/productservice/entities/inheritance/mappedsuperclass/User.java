package com.scaler.project.productservice.entities.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    private String userName;
    private String email;
}
