package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.UserDAO;
import com.example.model.Role;
import com.example.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDAO dao;

    @Autowired
    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<User> index() {
        return dao.index();
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public User show(int id) {
        return dao.show(id);
    }

    @Override
    public void update(User updatedUser) {
        dao.update(updatedUser);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return dao.getUserByUsername(userName);
    }

    @Override
    public void addAdminAndUserPanel() {

        Set<Role> admin = new HashSet<>();
        admin.add(new Role("admin"));
        admin.add(new Role("user"));
        dao.save(new User("admin", "admin", "admin@ya", admin));

        Set<Role> user = new HashSet<>();
        user.add(new Role("user"));
        dao.save(new User("user", "user", "user@ya", user));
    }
}
