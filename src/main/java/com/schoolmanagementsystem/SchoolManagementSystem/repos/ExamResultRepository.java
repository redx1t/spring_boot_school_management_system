package com.schoolmanagementsystem.SchoolManagementSystem.repos;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Attendance;
import com.schoolmanagementsystem.SchoolManagementSystem.models.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {

    Collection<ExamResult> findByStudentId(Long id);
}
