package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "grade_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Grade grade;

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
