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
}
