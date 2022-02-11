package com.schoolmanagementsystem.SchoolManagementSystem.repos;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Attendance;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> findByClassRoomId(Long id);
}
