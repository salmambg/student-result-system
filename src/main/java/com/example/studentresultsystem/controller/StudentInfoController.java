package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.dsdto.StudentWithoutDepartmentDTO;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.mapper.StudentMapper;
import com.example.studentresultsystem.response.ObjectResponse;
import com.example.studentresultsystem.service.StudentService;
import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentInfoController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{studentId}/info")
    public ResponseEntity<ObjectResponse> getStudentById(@PathVariable("studentId") @Valid Integer studentId) {

        Student student = studentService.getById(studentId);
        StudentWithoutDepartmentDTO studentDTO = StudentMapper.convertStudentRequestWithoutDepartmentDTO(student);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.STUDENT_FOUND, studentDTO));
    }
}
