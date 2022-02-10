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
public class TeacherService {
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;
    private final ExamTypeRepository examTypeRepository;
    private final ExamRepository examRepository;
    private final StaffRepository staffRepository;
    private final UserRepository userRepository;
    private final ExamResultRepository examResultRepository;
    private final ScheduleRepository scheduleRepository;
    private final AttendanceRepository attendanceRepository;
    public Attendance addAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    public Attendance findAttendance(Long id){
        return attendanceRepository.findById(id).get();
    }
    public Staff createStaff(Staff staff, User user){
        staff.setUser(user);
        Staff newstaff = staffRepository.save(staff);
        user.setStaff(newstaff);
        userRepository.save(user);
        return newstaff;
    }
    public Staff findStaff(Long id){
        return staffRepository.findById(id).get();
    }
    public ExamType addExamType(ExamType examType){
        return examTypeRepository.save(examType);
    }
    public Exam addExam(Exam exam){
        return examRepository.save(exam);
    }
    public ExamResult addExamResult(ExamResult examResult){
        return examResultRepository.save(examResult);
    }
    public Schedule addSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

}
