package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate start_date;
    private String start_time;
    private String end_time;
    private Boolean status;
    @ManyToOne
    private ExamType examType;
    @OneToOne
    private Staff staff;
    @OneToMany
    private Set<ExamResult> examResults = new HashSet<>();

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam )) return false;
        return id != null && id.equals(((Exam) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
