package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reports")
public class Report {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comments;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ExamResult> examResults = new HashSet<>();

}
