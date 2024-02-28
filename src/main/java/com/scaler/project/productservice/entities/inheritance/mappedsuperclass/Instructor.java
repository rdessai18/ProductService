package com.scaler.project.productservice.entities.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_instructor")
public class Instructor extends User {
    @Id
    private Long id;
    private String favStudentName;
    private String batch;
}
