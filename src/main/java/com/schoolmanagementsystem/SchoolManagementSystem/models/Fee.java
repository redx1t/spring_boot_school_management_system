package com.schoolmanagementsystem.SchoolManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "session_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "classroom_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ClassRoom classRoom;

    public Fee(String fee_name, Integer amount, String currency, Boolean isActive, Session session, ClassRoom aClass) {
        this.fee_name = fee_name;
        this.amount = amount;
        this.currency = currency;
        this.isActive = isActive;
        this.session = session;
        this.classRoom = aClass;
    }

    public Fee(String fee_name, Integer amount, String currency, Boolean isActive) {
        this.fee_name = fee_name;
        this.amount = amount;
        this.currency = currency;
        this.isActive = isActive;
    }

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
