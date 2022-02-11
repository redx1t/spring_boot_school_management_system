package com.schoolmanagementsystem.SchoolManagementSystem.service;

import com.schoolmanagementsystem.SchoolManagementSystem.models.*;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

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
    private final ClassRoomRepository classRoomRepository;
    public Attendance addAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }
    public Collection<ClassRoom> listAllClassRooms(){
        return classRoomRepository.findAll();
    }
    public ClassRoom findClassRoom(Long id){
        return classRoomRepository.findById(id).get();
    }
    public Collection<Student> findStudentsByClassRoom(Long id){
        return studentRepository.findByClassRoomId(id);
    }
    public Attendance findAttendance(Long id){
        return attendanceRepository.findById(id).get();
    }

    public ExamType addExamType(ExamType examType){
        return examTypeRepository.save(examType);
    }
    public ExamType findExamType(Long id){
        return examTypeRepository.findById(id).get();
    }
    public Exam addExam(Exam exam){
        return examRepository.save(exam);
    }
    public Exam findExam(Long id){
        return examRepository.findById(id).get();
    }
    public ExamResult addExamResult(ExamResult examResult){
        return examResultRepository.save(examResult);
    }
    public ExamResult findExamResult(Long id){
        return examResultRepository.findById(id).get();
    }
    public Schedule addSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).get();
    }

}
