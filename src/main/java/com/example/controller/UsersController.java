package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String loginPage() {
        userService.addAdminAndUserPanel();
        return "login";
    }

    @RequestMapping(value = "/user-page", method = RequestMethod.GET)
    public String userPage(ModelMap model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "user-page";
    }

}
