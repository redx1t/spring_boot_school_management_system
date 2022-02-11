package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "session_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Staff(String staff_id, String designation, String nationality) {
        this.staff_id = staff_id;
        this.designation = designation;
        this.nationality = nationality;
    }
}
