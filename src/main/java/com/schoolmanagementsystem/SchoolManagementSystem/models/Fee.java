package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fees")
public class Fee {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fee_name;
    private Integer amount;
    private String currency;
    private Boolean isActive;

    @OneToOne
    private Session session;

    @OneToOne
    private ClassRoom aClass;
}
