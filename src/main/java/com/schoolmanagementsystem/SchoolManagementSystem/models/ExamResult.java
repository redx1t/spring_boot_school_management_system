package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "exam_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Exam exam;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "staff_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
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
