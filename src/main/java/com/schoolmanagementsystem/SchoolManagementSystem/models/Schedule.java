package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String start_time;
    private String end_time;
    private Boolean status;
    @ManyToOne
    private ClassRoom aClass;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Staff staff;
}
