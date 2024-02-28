package com.scaler.project.productservice.entities.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_mentor")
public class Mentor extends User {
    @Id
    private Long id;
    private double averageUserRating;
}
