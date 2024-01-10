package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.DepartmentRequest;
import com.example.studentresultsystem.dto.StudentRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/signupDepartment")
    public ResponseEntity<Department> saveDepartment (@RequestBody @Valid DepartmentRequest departmentRequest) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment (@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody @Valid DepartmentRequest departmentRequest) throws UserNotFoundException {
       Department updatedDepartment= departmentService.updateDepartment(id, departmentRequest);
        return ResponseEntity.ok(updatedDepartment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) throws UserNotFoundException {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("delete id successfully :" + id);
    }

}
