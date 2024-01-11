package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.DepartmentRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.mapper.DepartmentMapper;
import com.example.studentresultsystem.response.ObjectResponse;
import com.example.studentresultsystem.service.DepartmentService;
import com.example.studentresultsystem.service.StudentService;
import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DSController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<ObjectResponse> create(@Valid @RequestBody DepartmentRequest request)
            throws UserNotFoundException {
        Department department = DepartmentMapper.convertDepartmentRequest(request);
        return new ResponseEntity<>(
                new ObjectResponse(true, Constants.DEPARTMENT_CREATED, DepartmentMapper.convertDepartmentWithoutStudentDTO(departmentService.create(department))),
                HttpStatus.CREATED);
    }
    @GetMapping
    public List<Department> getAllDepartments () {
        return departmentService.getAllDepartments();
    }

}
