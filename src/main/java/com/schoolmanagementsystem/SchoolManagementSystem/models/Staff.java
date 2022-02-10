package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staffs")
public class Staff {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String staff_id;
    private String designation;
    private String nationality;
    @OneToOne
    private User user;

    public Staff(String staff_id, String designation, String nationality) {
        this.staff_id = staff_id;
        this.designation = designation;
        this.nationality = nationality;
    }
}
