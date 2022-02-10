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

    public Setting(String school_name, String school_slogan, String school_location, String school_phone, String school_email) {
        this.school_name = school_name;
        this.school_slogan = school_slogan;
        this.school_location = school_location;
        this.school_phone = school_phone;
        this.school_email = school_email;
    }
}
