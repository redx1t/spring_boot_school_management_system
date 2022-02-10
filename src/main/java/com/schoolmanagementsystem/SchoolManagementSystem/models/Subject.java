package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany
    private Set<Schedule> schedules = new HashSet<>();

    public Subject(String subject, String abbreviation, Boolean isActive, Grade grade) {
        this.subject = subject;
        this.abbreviation = abbreviation;
        this.isActive = isActive;
        this.grade = grade;
    }

    public Subject(String subject, String abbreviation, Boolean isActive) {
        this.subject = subject;
        this.abbreviation = abbreviation;
        this.isActive = isActive;
    }
}
