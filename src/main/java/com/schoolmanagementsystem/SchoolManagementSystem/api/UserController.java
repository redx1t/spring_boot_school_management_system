package com.schoolmanagementsystem.SchoolManagementSystem.api;

import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserService userService;
    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping

    public List<User> getUsers(int page){
        return userService.getUsers(page);
    }
}
