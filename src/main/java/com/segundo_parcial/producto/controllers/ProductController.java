package com.segundo_parcial.producto.controllers;

import com.segundo_parcial.producto.models.Product;
import com.segundo_parcial.producto.service.ProductServiceImp;
import com.segundo_parcial.producto.utils.ApiResponse;
import com.segundo_parcial.producto.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;
    private ApiResponse apiResponse;

    @GetMapping(value = "/product/{id}")
    public ResponseEntity getById(@PathVariable(name = "id") Long id) {
        try {
            apiResponse = new ApiResponse(Constants.REGISTER_FOUND, productServiceImp.getProductById(id));
            System.out.println(apiResponse);
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_FOUND, e.getMessage());
            return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List> getAllProduct() {

        try {
            apiResponse = new ApiResponse(Constants.REGISTERS_FOUND, productServiceImp.getAllProduct());
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            apiResponse = new ApiResponse(Constants.REGISTERS_NOT_FOUND, e.getMessage());
            return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/product")
    public ResponseEntity createProduct(@RequestBody Product product) {

        try {
            apiResponse = new ApiResponse(Constants.REGISTER_CREATED, productServiceImp.createProduct(product));
            return new ResponseEntity(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_CREATED, e.getMessage());
            return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/product/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {

        try {
            apiResponse = new ApiResponse(Constants.REGISTER_UPDATED, productServiceImp.updateProduct(id, product));
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_UPDATED, e.getMessage());
            return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "product/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id, Product product) {

        //ap response = new HashMap();
        Boolean productDB = productServiceImp.deleteProduct(id, product);
        try {
            if (productDB == null) {
                apiResponse = new ApiResponse(Constants.REGISTER_NOT_FOUND, "");
                return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
                //response.put("massage", "No se encontró el producto");
                //return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                apiResponse = new ApiResponse(Constants.REGISTER_UPDATED, productDB);
                return new ResponseEntity(apiResponse, HttpStatus.OK);
                //response.put("massage", "Se eliminó el producto");
                //return new ResponseEntity(response, HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_DELETE, e.getMessage());
            return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
            //response.put("massage", "Error al eliminar");
            //return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

}
