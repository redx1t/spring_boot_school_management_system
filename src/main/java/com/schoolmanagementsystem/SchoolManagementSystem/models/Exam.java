package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exams")
public class Exam {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate start_date;
    private String start_time;
    private String end_time;
    private Boolean status;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "exam_type_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ExamType examType;
    @OneToOne
    private Staff staff;
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "classroom_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClassRoom classRoom;

    public Exam(String name, LocalDate start_date, String start_time, String end_time, Boolean status, ExamType examType, Staff staff, ClassRoom classRoom) {
        this.name = name;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.examType = examType;
        this.staff = staff;
        this.classRoom = classRoom;
    }

    public Exam(String name, LocalDate start_date, String start_time, String end_time, Boolean status) {
        this.name = name;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exam )) return false;
        return id != null && id.equals(((Exam) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
