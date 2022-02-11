package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.ClassRoom;
import com.schoolmanagementsystem.SchoolManagementSystem.models.ExamResult;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ClassRoomRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ExamResultRepository;
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
    private final ClassRoomRepository classRoomRepository;
    private final ExamResultRepository examResultRepository;
    public Collection<ExamResult> getResults(Long id){
        return examResultRepository.findByStudentId(id);
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student assignClassToStudent(Student student, ClassRoom classRoom){
        student.setClassRoom(classRoom);
        studentRepository.save(student);
        return student;
    }
    public Student findStudent(Long id){
        return studentRepository.findById(id).get();
    }
}
