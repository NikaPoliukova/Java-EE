package com.example.repository;

import com.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final Connection connection;

    private static final String SHOW_All_USERS = "SELECT user_name FROM registered_users";
    private final static String ADD_USER = "INSERT INTO registered_users (user_name, password) VALUES (?,?)";
    private static final String SHOW_USER = "SELECT * FROM registered_users WHERE user_name = ? and password =?";

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<User> findUsers() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SHOW_All_USERS);
            final List<User> userList = new ArrayList<User>();
            while (rs.next()) {
                final User user = new User(rs.getString("user_name"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addUser(User user) {

        try {
            PreparedStatement ps = connection.prepareStatement(ADD_USER);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("не удалось добавить");
        }
        return true;

    }

    public boolean getUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement(SHOW_USER);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

