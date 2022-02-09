package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classrooms")
public class ClassRoom {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String abbreviation;
    private Boolean isActive;
    @OneToOne
    private Grade grade;
    @OneToOne
    private Session session;
    @OneToOne
    private Staff staff;
}
