package com.schoolmanagementsystem.SchoolManagementSystem.repos;

import com.schoolmanagementsystem.SchoolManagementSystem.models.ClassRoom;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassRoom, Long> {

}
