package com.example.mvcsecurityboot;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MvcSecurityBootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MvcSecurityBootApplication.class, args);
    }

}
