package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String second_name;
    @Column(unique = true)
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Column(unique = true)
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private String gender;
    private LocalDate dob;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @Transient

    private Integer age;

    public User(String first_name, String second_name, String email, String phone, String password, String gender, LocalDate dob, LocalDateTime created_at, LocalDateTime updated_at) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


}
