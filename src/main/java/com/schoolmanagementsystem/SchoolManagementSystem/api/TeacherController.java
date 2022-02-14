package com.schoolmanagementsystem.SchoolManagementSystem.api;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Response;
import com.schoolmanagementsystem.SchoolManagementSystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping(path = "/classrooms")
    public ResponseEntity<Response> getClassRooms()
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("classrooms", teacherService.listAllClassRooms()))
                        .message("classrooms retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }
    // modify this to take get parameters or post request
    @GetMapping(path = "/classroom/get")
    public ResponseEntity<Response> getUsers(@RequestParam(value = "classroom") int classroom)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("classroom", teacherService.findClassRoom((long) classroom)))
                        .message("classroom retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );

    }
    // modify to take get or post request
    @GetMapping(path = "/classroom/students")
    public ResponseEntity<Response> getStudentsByClassRoom(@RequestParam(value = "classroom") int classroom)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("students", teacherService.findStudentsByClassRoom((long) classroom)))
                        .message("students retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );

    }
}
