package com.scaler.project.productservice.entities.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("1")
public class Instructor extends User {
    private String favStudentName;
    private String batch;
}
