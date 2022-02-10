package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.ExamResult;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    public Collection<ExamResult> getResults(Long id){
        return studentRepository.findById(id).orElseThrow().getExamResults();
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student findStudent(Long id){
        return studentRepository.findById(id).get();
    }
}
