package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.*;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AdminService {
    private final SessionRepository sessionRepository;
    private final ClassRoomRepository classRoomRepository;
    private final GradeRepository gradeRepository;
    private final FeeRepository feeRepository;
    private final SettingRepository settingRepository;
    private final SubjectRepository subjectRepository;
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public Subject findSubject(Long id){
        return subjectRepository.findById(id).get();
    }
    public Setting addSetting(Setting setting){
        return settingRepository.save(setting);
    }
    public Setting findSetting(Long id){
        return settingRepository.findById(id).get();
    }
    public Session addSession(Session session){
        return sessionRepository.save(session);
    }
    public Session findSession(Long id){
        return sessionRepository.findById(id).get();
    }
    public Fee addFee(Fee fee){
        return feeRepository.save(fee);
    }
    public Fee findFee(Long id){
        return feeRepository.findById(id).get();
    }
    public Grade addGrade(Grade grade){
        return gradeRepository.save(grade);
    }
    public Grade findGrade(Long id){
        return gradeRepository.findById(id).get();
    }
    public ClassRoom addClassRoom(ClassRoom classRoom){
        return classRoomRepository.save(classRoom);
    }
    public ClassRoom findClassRoom(Long id){
        return classRoomRepository.findById(id).get();
    }

    public Staff saveStaff(Staff staff){
        return staffRepository.save(staff);
    }
    public Staff createStaff(Staff staff, User user){
        staff.setUser(user);
        staffRepository.save(staff);
        return staff;
    }
    public Staff findStaff(Long id){
        return staffRepository.findById(id).get();
    }
}
