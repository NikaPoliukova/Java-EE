package com.example.service;

import java.util.List;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public boolean getUser(User user) {
        return userRepository.getUser(user);
    }

}