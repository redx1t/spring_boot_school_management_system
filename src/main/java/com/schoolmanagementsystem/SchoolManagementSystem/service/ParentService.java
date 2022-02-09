package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Parent;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ParentRepository;
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
public class ParentService {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;

    public Collection<Student> getStudents(User user){
        return (parentRepository.findByUserId(user.getId())).getStudents();
    }
    public boolean createStudent(Student student, Parent parent){
        parent.getStudents().add(student);
        return true;
    }
    public Parent create(Parent parent){
        return parentRepository.save(parent);
    }

}
