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
    @OneToOne
    private Exam exam;
    @OneToOne
    private Student student;
    @OneToOne
    private Staff staff;
}
