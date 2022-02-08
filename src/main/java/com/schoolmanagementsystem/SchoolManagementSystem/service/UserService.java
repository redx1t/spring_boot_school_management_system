package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Role;
import com.schoolmanagementsystem.SchoolManagementSystem.models.User;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.RoleRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null){
            log.info("user not found");
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public Collection<User> getUsers(int page) {
        return userRepository.findAll(PageRequest.of(page, 10)).toList();
    }
    public User getUser(Long id){
        return userRepository.findById(id).get();
    }
    public User getUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public User update(User user){
        return userRepository.save(user);
    }
    public Role createRole(Role role){
        return roleRepository.save(role);
    }
    public void addRoleToUser(String email, String name){
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(name);
        user.getRoles().add(role);
    }



}
