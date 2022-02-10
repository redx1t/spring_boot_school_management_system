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
    public Subject addSubject(Subject subject){
        return subjectRepository.save(subject);
    }
    public Setting addSetting(Setting setting){
        return settingRepository.save(setting);
    }
    public Session addSession(Session session){
        return sessionRepository.save(session);
    }
    public Fee addFee(Fee fee){
        return feeRepository.save(fee);
    }
    public Grade addGrade(Grade grade){
        return gradeRepository.save(grade);
    }
    public ClassRoom addClassRoom(ClassRoom classRoom){
        return classRoomRepository.save(classRoom);
    }
}
