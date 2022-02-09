package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @OneToOne
    private Staff staff;
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
