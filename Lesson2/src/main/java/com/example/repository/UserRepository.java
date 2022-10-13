package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.model.User;

public interface UserRepository {

    List<User> findUsers();

    boolean getUser(String name, String password);

    void addUser(String name, String password);


}