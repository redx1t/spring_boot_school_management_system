package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate date;
    private String nationality;
    private String gender;
    private String religion;
    @Column(unique = true)
    private String adm_no;
    @OneToOne
    private ClassRoom aClass;
    @OneToOne
    private Parent parent;
    @OneToMany
    private Collection<ExamResult> examResults = new ArrayList<>();
}
