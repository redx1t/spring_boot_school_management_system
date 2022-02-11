package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "classroom_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ClassRoom classRoom;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "subject_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Subject subject;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "staff_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Staff staff;

    public Schedule(LocalDate date, String start_time, String end_time, Boolean status, ClassRoom aClass, Subject subject, Staff staff) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.classRoom = aClass;
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
