package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    @OneToMany
    private Set<ExamResult> examResults = new HashSet<>();
    public void addExamResult(ExamResult examResult){
        examResults.add(examResult);
        examResult.setStudent(this);
    }
    public void removeBook(ExamResult examResult){
        examResults.remove(examResult);
        examResult.setStudent(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student )) return false;
        return id != null && id.equals(((Student) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
