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
@Table(name = "table_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private LocalDateTime updated_at;
}
