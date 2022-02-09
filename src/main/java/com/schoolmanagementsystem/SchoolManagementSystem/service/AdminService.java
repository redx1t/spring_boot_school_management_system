package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.repos.AttendanceRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ClassRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ExamRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService {
    private final UserRepository userRepository;
    private final AttendanceRepository attendanceRepository;
    private final ClassRepository classRepository;
    private final ExamRepository examRepository;
}
