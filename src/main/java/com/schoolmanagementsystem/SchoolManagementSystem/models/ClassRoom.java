package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne
    private Grade grade;
    @ManyToOne
    private Session session;
    @ManyToOne
    private Staff staff;
    @OneToMany
    private Set<Schedule> schedules = new HashSet<>();

    public ClassRoom(String name, String abbreviation, Boolean isActive, Grade grade, Session session, Staff staff) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.isActive = isActive;
        this.grade = grade;
        this.session = session;
        this.staff = staff;
    }

    public ClassRoom(String name, String abbreviation, Boolean isActive) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassRoom )) return false;
        return id != null && id.equals(((ClassRoom) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
