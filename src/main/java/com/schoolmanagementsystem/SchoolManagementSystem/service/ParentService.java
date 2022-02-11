package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.ExamResult;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Parent;
import com.schoolmanagementsystem.SchoolManagementSystem.models.Student;
import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.ParentRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.StudentRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ParentService {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    public Student getParentStudents(Long id){
        Parent parent = parentRepository.findByUserId(id);
        return parent.getStudent();
        //Parent parent = parentRepository.getById(user.getParent().getId());
        //return parent.getStudents();
    }

    public Parent setParentToStudent(Parent parent, Student student){
        parent.setStudent(student);
        parentRepository.save(parent);
        return parent;
    }

    public Parent saveParent(Parent parent, User user){
        parent.setUser(user);
        return parentRepository.save(parent);
    }
    public Parent findParent(Long id){
        return parentRepository.findById(id).get();
    }


}
