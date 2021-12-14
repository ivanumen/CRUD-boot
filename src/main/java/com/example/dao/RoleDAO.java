package com.example.dao;

import com.example.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleByName(String name);

    Role show(int id);

    List<Role> index();

    Role getDefaultRole();
}
