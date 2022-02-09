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
@Table(name = "reports")
public class Report {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comments;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<ExamResult> examResults = new ArrayList<>();
}
