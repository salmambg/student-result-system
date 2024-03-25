package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.dsdto.StudentSemesterRequest;
import com.example.studentresultsystem.response.ApiResponse;
import com.example.studentresultsystem.service.StudentSemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-enrollment")
public class StudentSemesterController {

    @Autowired
    StudentSemesterService studentSemesterService;

    @PostMapping
    public ResponseEntity<ApiResponse> saveSemestersInStudents(@RequestBody StudentSemesterRequest request) {
        studentSemesterService.saveSemesterInStudent(request);
        return ResponseEntity.ok().body(new ApiResponse(true,"Student successfully enrolled in semesters"));
    }

}
