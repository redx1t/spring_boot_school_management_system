package com.schoolmanagementsystem.SchoolManagementSystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "settings")
public class Setting {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String school_name;
    private String school_slogan;
    private String school_location;
    private String school_phone;
    private String school_email;
}
