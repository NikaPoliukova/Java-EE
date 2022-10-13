package com.example.service;

import java.util.List;
import com.example.model.User;
import com.example.repository.UserRepository;


public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    public void addUser(String name, String password) {
        userRepository.addUser(name, password);
    }

    public boolean getUser(String name, String password) {
        return userRepository.getUser(name, password);
    }

}