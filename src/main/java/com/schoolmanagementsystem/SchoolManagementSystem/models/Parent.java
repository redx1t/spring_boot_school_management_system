package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parents")
public class Parent {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    @OneToMany()
    private Collection<Student> students = new ArrayList<>();;
}
