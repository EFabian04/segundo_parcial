package com.segundo_parcial.producto.service;

import com.segundo_parcial.producto.models.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> allUsers();

    User createUser(User user);

    User updateUser(Long id, User user);

    String login(User user);
}
