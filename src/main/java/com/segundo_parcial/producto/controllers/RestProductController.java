package com.segundo_parcial.producto.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.segundo_parcial.producto.models.ApiProduct;
import com.segundo_parcial.producto.models.Product;
import com.segundo_parcial.producto.service.RestProductService;
import com.segundo_parcial.producto.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products/")
public class RestProductController {
    private final RestProductService restProductService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) throws JsonProcessingException {

        return new ResponseEntity(restProductService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ApiProduct>> getAllProducts() throws JsonProcessingException {
        return new ResponseEntity(restProductService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity saveProduct(@PathVariable Long id) throws JsonProcessingException {

        Product product = restProductService.saveProduct(id);
        if (product == null) {
            return new ResponseEntity<>(Constants.REGISTER_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        System.out.println(product);
        return new ResponseEntity(product, HttpStatus.ACCEPTED);
    }
}