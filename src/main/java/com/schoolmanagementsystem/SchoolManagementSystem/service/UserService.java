package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public List<User> getUsers(int page) {
        return userRepository.findAll(PageRequest.of(page, 10)).toList();
    }
    public User getUser(Long id){
        return userRepository.findById(id).get();
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public User update(User user){
        return userRepository.save(user);
    }
}
