package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "grade_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Grade grade;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "session_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "staff_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Staff staff;


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
