package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parents")
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    @OneToOne
    private User user;
    @OneToMany()
    private Set<Student> students = new HashSet<>();
    public void addStudent(Student student){
        students.add(student);
        student.setParent(this);
    }
    public void removeStudent(Student student){
        students.remove(student);
        student.setParent(null);
    }
}
