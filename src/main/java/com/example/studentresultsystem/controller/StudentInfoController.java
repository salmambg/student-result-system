package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.StudentWithSemesterAndDepartmentDTO;
import com.example.studentresultsystem.dto.dsdto.StudentWithoutDepartmentDTO;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.mapper.StudentMapper;
import com.example.studentresultsystem.repository.ResultRepository;
import com.example.studentresultsystem.request.StuSubResRequest;
import com.example.studentresultsystem.response.ObjectResponse;
import com.example.studentresultsystem.service.ResultService;
import com.example.studentresultsystem.service.SemesterService;
import com.example.studentresultsystem.service.StudentService;
import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentInfoController {

    @Autowired
    StudentService studentService;
    @Autowired
    SemesterService semesterService;
    @Autowired
    ResultRepository resultRepository;
    @Autowired
    ResultService resultService;

    @GetMapping("/{studentId}/info")
    public ResponseEntity<ObjectResponse> getStudentById(@PathVariable("studentId") @Valid Integer studentId) {

        Student student = studentService.getById(studentId);
        StudentWithSemesterAndDepartmentDTO studentDTO = StudentMapper.convertStudentRequestWithDepartmentAndSemesterDTO(student);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.STUDENT_FOUND, studentDTO));
    }
    @PostMapping("/result")
    public ResponseEntity<ObjectResponse> saveResultForSubject(@RequestBody StuSubResRequest request){
        Map<String, Object> result = resultService.getStudentResultWithGrade(request);
        return ResponseEntity.ok().body(new ObjectResponse(true,"Result", result));
    }


}
