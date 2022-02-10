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
@Table(name = "school_sessions")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Year;
    private String term;
    private Boolean isActive;

    @OneToMany
    private Set<ClassRoom> classRooms = new HashSet<>();

}
