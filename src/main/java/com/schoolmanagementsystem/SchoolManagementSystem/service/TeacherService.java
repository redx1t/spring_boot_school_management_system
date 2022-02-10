package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Parent;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ParentRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeacherService {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;

    public Parent create(Parent parent){
        return parentRepository.save(parent);
    }

}
