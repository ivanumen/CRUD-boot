package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.RoleDAO;
import com.example.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private RoleDAO dao;

    @Autowired
    public void setDao(RoleDAO dao) {
        this.dao = dao;
    }

    @Override
    public Role getRoleByName(String name) {
        return dao.getRoleByName(name);
    }

    @Override
    public Role show(int id) {
        return dao.show(id);
    }

    @Override
    public List<Role> index() {
        return dao.index();
    }

    @Override
    public Role getDefaultRole() {
        return dao.getDefaultRole();
    }

}
