package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class Class {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String abbreviation;
    private Boolean isActive;
    @OneToOne(fetch = FetchType.EAGER)
    private Grade grade;
    @OneToOne(fetch = FetchType.EAGER)
    private Session session;
    @OneToOne(fetch = FetchType.EAGER)
    private Staff staff;
}
