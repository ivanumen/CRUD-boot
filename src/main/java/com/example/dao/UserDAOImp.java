package com.example.dao;

import org.springframework.stereotype.Repository;
import com.example.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getUserByUsername(String userName) {
        return (User)entityManager
                .createQuery("select user from User user where user.userName = :userName", User.class)
                .setParameter("userName", userName)
                .getSingleResult();

    }

    @Override
    public boolean isNotReg(String name) {
        return index()
                .stream()
                .anyMatch((e) -> e.getUsername().hashCode() == name.hashCode());
    }
}
