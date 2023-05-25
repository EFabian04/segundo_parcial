package com.segundo_parcial.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.segundo_parcial.producto.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
