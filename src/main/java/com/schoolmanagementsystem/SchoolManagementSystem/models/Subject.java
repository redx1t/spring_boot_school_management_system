package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects")
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subject;
    private String abbreviation;
    private Boolean isActive;
    @OneToOne
    private Grade grade;

}
