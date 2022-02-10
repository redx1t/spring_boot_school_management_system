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
