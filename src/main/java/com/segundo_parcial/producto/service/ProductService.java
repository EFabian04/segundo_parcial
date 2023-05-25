package com.segundo_parcial.producto.service;

import com.segundo_parcial.producto.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProduct();

    Product createProduct(Product product);

    Boolean updateProduct(Long id, Product product);

    Boolean deleteProduct(Long id, Product product);
}
