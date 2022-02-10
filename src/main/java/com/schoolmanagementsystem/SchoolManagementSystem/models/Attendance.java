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
@Table(name = "attendances")
public class Attendance {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private boolean status;
    private String remarks;

    @OneToOne
    private Student student;
    @OneToOne
    private ClassRoom classRoom;
    @OneToOne
    private Staff staff;

    public Attendance(LocalDate date, boolean status, String remarks, Student student, ClassRoom classRoom, Staff staff) {
        this.date = date;
        this.status = status;
        this.remarks = remarks;
        this.student = student;
        this.classRoom = classRoom;
        this.staff = staff;
    }

    public Attendance(LocalDate date, boolean status, String remarks) {
        this.date = date;
        this.status = status;
        this.remarks = remarks;
    }
}
