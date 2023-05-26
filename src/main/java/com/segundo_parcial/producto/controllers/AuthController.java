package com.segundo_parcial.producto.controllers;

import com.segundo_parcial.producto.models.User;
import com.segundo_parcial.producto.service.UserService;
import com.segundo_parcial.producto.utils.ApiResponse;
import com.segundo_parcial.producto.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    private ApiResponse apiResponse;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        try {
            apiResponse = new ApiResponse(Constants.USER_LOGIN, userService.login(user));
            return new ResponseEntity(apiResponse, HttpStatus.OK);

        } catch (Exception e) {
            apiResponse = new ApiResponse(e.getMessage(), "");
            return new ResponseEntity(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}