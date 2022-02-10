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
@Table(name = "exams_results")
public class ExamResult {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String points;
    private String comments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Exam exam;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    private Staff staff;

    public ExamResult(String points, String comments, Exam exam, Student student, Staff staff) {
        this.points = points;
        this.comments = comments;
        this.exam = exam;
        this.student = student;
        this.staff = staff;
    }

    public ExamResult(String points, String comments) {
        this.points = points;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamResult )) return false;
        return id != null && id.equals(((ExamResult) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
