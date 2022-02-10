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

    public Schedule(LocalDate date, String start_time, String end_time, Boolean status, ClassRoom aClass, Subject subject, Staff staff) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.aClass = aClass;
        this.subject = subject;
        this.staff = staff;
    }

    public Schedule(LocalDate date, String start_time, String end_time, Boolean status) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
    }
}
