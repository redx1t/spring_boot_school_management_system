package com.schoolmanagementsystem.SchoolManagementSystem.configs;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Role;
import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService){
        return args -> {
            User defaultAdmin = new User(
                    "admin",
                    "default",
                    "admin1",
                    "admin@admin.com",
                    "0700000001",
                    "admin@123",
                    "female",
                    LocalDate.of(2000, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultTeacher = new User(
                    "teacher",
                    "default",
                    "teacher1",
                    "teacher@admin.com",
                    "0700000002",
                    "admin@123",
                    "female",
                    LocalDate.of(1998, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultBursar = new User(
                    "bursar",
                    "default",
                    "bursar1",
                    "bursar@admin.com",
                    "0700000003",
                    "admin@123",
                    "female",
                    LocalDate.of(1988, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultParent = new User(
                    "parent",
                    "default",
                    "parent1",
                    "parent@admin.com",
                    "0700000004",
                    "admin@123",
                    "female",
                    LocalDate.of(1978, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            userService.create(defaultAdmin);
            userService.create(defaultTeacher);
            userService.create(defaultBursar);
            userService.create(defaultParent);
            userService.createRole(new Role(null, "ROLE_ADMIN", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_TEACHER", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_BURSAR", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_PARENT", LocalDateTime.now()));
            userService.addRoleToUser("admin1", "ROLE_ADMIN");
            userService.addRoleToUser("teacher1", "ROLE_TEACHER");
            userService.addRoleToUser("bursar1", "ROLE_BURSAR");
            userService.addRoleToUser("parent1", "ROLE_PARENT");

        };
    }
}
