package com.schoolmanagementsystem.SchoolManagementSystem.configs;

import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User defaultAdmin = new User(
                    "admin",
                    "default",
                    "admin@admin.com",
                    "phone",
                    "admin@123",
                    "gender",

                    LocalDate.of(2000, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            repository.save(defaultAdmin);
        };
    }
}
