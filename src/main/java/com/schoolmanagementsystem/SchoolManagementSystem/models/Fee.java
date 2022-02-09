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

    @ManyToOne
    private Session session;

    @ManyToOne
    private ClassRoom aClass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fee )) return false;
        return id != null && id.equals(((Fee) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
