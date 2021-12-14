package com.example.service;

import com.example.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    Role show(int id);

    List<Role> index();

    Role getDefaultRole();

}
