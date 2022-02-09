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
    @OneToOne(fetch = FetchType.EAGER)
    private Exam exam;
    @OneToOne(fetch = FetchType.EAGER)
    private Student student;
    @OneToOne(fetch = FetchType.EAGER)
    private Staff staff;
}
