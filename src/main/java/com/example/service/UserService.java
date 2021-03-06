package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.example.model.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    List<User> index();

    void save(User user);

    User show(int id);

    void update(User updatedUser);

    void delete(int id);

    void addAdminAndUserPanel();
}
