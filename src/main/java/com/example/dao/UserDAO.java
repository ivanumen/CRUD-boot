package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDAO {

    List<User> index();

    void save(User user);

    User show(int id);

    void update(User updatedUser);

    void delete(int id);

    User getUserByUsername(String userName);

    boolean isNotReg(String name);
}
