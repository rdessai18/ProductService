package com.scaler.project.productservice.entities.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructor")
public class Instructor extends User {
    private String favStudentName;
    private String batch;
}
