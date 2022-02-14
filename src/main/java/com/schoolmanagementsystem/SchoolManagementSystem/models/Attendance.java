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
@Table(name = "attendances")
public class Attendance {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private boolean status;
    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "student_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "classroom_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClassRoom classRoom;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "staff_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
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
