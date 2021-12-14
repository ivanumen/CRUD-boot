package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.model.User;
import com.example.service.RoleService;
import com.example.service.UserService;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/admin/page", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "admin-page";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String newUser(@ModelAttribute("users") User user) {
        return "add-new-user";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String postNewUser(Model model, @ModelAttribute("users") User user) {
        userService.save(user);
        return index(model);
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("users", userService.show(id));
        return "edit-user";
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String postUpdateUser(Model model, @ModelAttribute("users") User user) {
        userService.update(user);
        return update(model, user.getId());
    }

    @RequestMapping(value = "/admin/remove", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin/page";
    }
}
