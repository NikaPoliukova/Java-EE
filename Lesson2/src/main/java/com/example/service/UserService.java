package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();

    boolean addUser(User user);

    boolean getUser(User user);
}
