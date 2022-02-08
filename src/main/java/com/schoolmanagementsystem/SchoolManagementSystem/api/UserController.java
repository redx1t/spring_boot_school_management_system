package com.schoolmanagementsystem.SchoolManagementSystem.api;

import com.schoolmanagementsystem.SchoolManagementSystem.configs.RoleToUserForm;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Response;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Role;
import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/page/{page}")

    public ResponseEntity<Response> getUsers(@PathVariable("page") int page)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("users", userService.getUsers(page)))
                        .message("users retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );

    }

    @PostMapping(path = "/save")
    public ResponseEntity<Response>createUser(@RequestBody User user){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("user", userService.create(user)))
                        .message("User created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @PostMapping(path = "/role/save")
    public ResponseEntity<Response>createRole(@RequestBody Role role){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("role", userService.createRole(role)))
                        .message("Role created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @PostMapping(path = "/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.getName());
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("Role Added")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

}
