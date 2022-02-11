package com.schoolmanagementsystem.SchoolManagementSystem.api;

import com.schoolmanagementsystem.SchoolManagementSystem.models.Response;
import com.schoolmanagementsystem.SchoolManagementSystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(path = "/classroom/get/{classroom}")
    public ResponseEntity<Response> getUsers(@PathVariable("classroom") int classroom)
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
    @GetMapping(path = "/classroom/students/{classroom}")
    public ResponseEntity<Response> getStudentsByClassRoom(@PathVariable("classroom") int classroom)
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
