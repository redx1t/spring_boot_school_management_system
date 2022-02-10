package com.schoolmanagementsystem.SchoolManagementSystem.api;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Response;
import com.schoolmanagementsystem.SchoolManagementSystem.service.ParentService;
import com.schoolmanagementsystem.SchoolManagementSystem.service.StudentService;
import com.schoolmanagementsystem.SchoolManagementSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;
    private final UserService userService;
    private final StudentService studentService;
    @GetMapping(path = "/students/parent/{user_id}")
    public ResponseEntity<Response> getStudents(@PathVariable(value = "user_id", required = true) int user_id)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("students", parentService.getParentStudents((long) user_id)))
                        .message("students retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    @GetMapping(path = "/student?student_id={id}")
    public ResponseEntity<Response> getExamResults(@PathVariable(value = "id", required = true) int id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("exam_results", studentService.getResults((long) id)))
                        .message("exam results retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
}
