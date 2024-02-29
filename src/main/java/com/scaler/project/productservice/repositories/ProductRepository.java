package com.scaler.project.productservice.repositories;

import com.scaler.project.productservice.models.Product;
import com.scaler.project.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p.id as id, p.title as title from Product p where p.id=?1")
    ProductWithIdAndTitle findProductWithIdAndTitle(Long id);
}
