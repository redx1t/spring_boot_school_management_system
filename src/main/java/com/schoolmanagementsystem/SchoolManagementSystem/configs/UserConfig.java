package com.schoolmanagementsystem.SchoolManagementSystem.configs;

import com.schoolmanagementsystem.SchoolManagementSystem.models.*;
import com.schoolmanagementsystem.SchoolManagementSystem.repos.UserRepository;
import com.schoolmanagementsystem.SchoolManagementSystem.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(AdminService adminService, TeacherService teacherService, UserService userService, ParentService parentService, StudentService studentService){
        return args -> {
            User defaultAdmin = new User(
                    "admin",
                    "default",
                    "admin1",
                    "admin@admin.com",
                    "0700000001",
                    "admin@123",
                    "female",
                    LocalDate.of(2000, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultTeacher = new User(
                    "teacher",
                    "default",
                    "teacher1",
                    "teacher@admin.com",
                    "0700000002",
                    "admin@123",
                    "female",
                    LocalDate.of(1998, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultBursar = new User(
                    "bursar",
                    "default",
                    "bursar1",
                    "bursar@admin.com",
                    "0700000003",
                    "admin@123",
                    "female",
                    LocalDate.of(1988, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );
            User defaultParent = new User(
                    "parent",
                    "default",
                    "parent1",
                    "parent@admin.com",
                    "0700000004",
                    "admin@123",
                    "female",
                    LocalDate.of(1978, Month.JANUARY, 20),
                    true,
                    LocalDateTime.now(),
                    LocalDateTime.now()
            );

            userService.create(defaultAdmin);
            User userstaff = userService.create(defaultTeacher);
            userService.create(defaultBursar);
            Parent parent = parentService.saveParent(new Parent("address"), userService.create(defaultParent));
            Student student = studentService.createStudent(new Student("yvonne", "odhiambo", LocalDate.of(2003, Month.AUGUST, 20), "kenyan", "male", "christian", "12332"));
            parentService.setParentToStudent(parent, student);
            Student student1 = studentService.createStudent(new Student("victor", "muthomi", LocalDate.of(2003, Month.AUGUST, 20), "kenyan", "male", "christian", "12322"));
            Student student2 = studentService.createStudent(new Student("james", "wagure", LocalDate.of(2003, Month.AUGUST, 20), "kenyan", "male", "christian", "12700"));
            parentService.setParentToStudent(parent, student1);
            parentService.setParentToStudent(parent, student2);
            userService.createRole(new Role(null, "ROLE_ADMIN", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_TEACHER", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_BURSAR", LocalDateTime.now()));
            userService.createRole(new Role(null, "ROLE_PARENT", LocalDateTime.now()));
            userService.addRoleToUser("admin1", "ROLE_ADMIN");
            userService.addRoleToUser("teacher1", "ROLE_TEACHER");
            userService.addRoleToUser("bursar1", "ROLE_BURSAR");
            userService.addRoleToUser("parent1", "ROLE_PARENT");
            Staff staff = adminService.saveStaff(new Staff("staff_id", "teacher", "kenyan"));
            Staff newstaff = adminService.createStaff(staff, userstaff);

            Session session = adminService.addSession(new Session("2021", "1", true));
            Grade grade = adminService.addGrade(new Grade("class 1", "class one description"));
            ClassRoom classRoom = adminService.addClassRoom(new ClassRoom("class 1", "abbreviation", true, grade, session, newstaff));
            ClassRoom classRoom1 = adminService.addClassRoom(new ClassRoom("class 2", "abbreviation", true, grade, session, newstaff));

            studentService.assignClassToStudent(student, classRoom);
            studentService.assignClassToStudent(student1, classRoom1);
            studentService.assignClassToStudent(student2, classRoom1);

            ExamType examType = teacherService.addExamType(new ExamType("Start of Term", "Start of term exams"));
            Exam exam = new Exam("2021 start of term", LocalDate.now(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), true, examType, newstaff, classRoom);
            Exam newexam = teacherService.addExam(exam);
            teacherService.addExamResult(new ExamResult("60%", "comments", newexam, student, newstaff));
            teacherService.addExamResult(new ExamResult("80%", "different comments", newexam, student, newstaff));
            teacherService.addExamResult(new ExamResult("90%", "success comments", newexam, student, newstaff));
            Fee fee = adminService.addFee(new Fee("First Time Fee", 12000, "Kes", true, session, classRoom));
            Setting setting = adminService.addSetting(new Setting("default_school", "slogan", "location, sublocation", "0700100000", "schoolemail@school.com"));
            Subject maths = adminService.addSubject(new Subject("Mathematics", "Math", true, grade));
            Subject english = adminService.addSubject(new Subject("British English", "ENG", true, grade));
            teacherService.addSchedule(new Schedule(LocalDate.now(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), true, classRoom, maths, newstaff));
            teacherService.addSchedule(new Schedule(LocalDate.now(), LocalDateTime.now().toString(), LocalDateTime.now().toString(), true, classRoom, english, newstaff));
            teacherService.addAttendance(new Attendance(LocalDate.now(), true, "clean boy", student, classRoom, newstaff));
        };
    }
}
