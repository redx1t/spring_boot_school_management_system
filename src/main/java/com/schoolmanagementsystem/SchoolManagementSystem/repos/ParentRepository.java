package com.schoolmanagementsystem.SchoolManagementSystem.repos;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Attendance;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

}
