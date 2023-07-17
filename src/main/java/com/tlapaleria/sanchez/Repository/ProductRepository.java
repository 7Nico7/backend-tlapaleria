package com.tlapaleria.sanchez.Repository;

import com.tlapaleria.sanchez.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
