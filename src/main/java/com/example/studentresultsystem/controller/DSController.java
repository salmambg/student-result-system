package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.dsdto.DepartmentRequest;
import com.example.studentresultsystem.dto.dsdto.StudentDTO;
import com.example.studentresultsystem.dto.dsdto.StudentRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.mapper.DepartmentMapper;
import com.example.studentresultsystem.mapper.StudentMapper;
import com.example.studentresultsystem.response.ApiResponse;
import com.example.studentresultsystem.response.ObjectResponse;
import com.example.studentresultsystem.service.DepartmentService;
import com.example.studentresultsystem.service.StudentService;
import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/students")
    public ResponseEntity<ObjectResponse> createStudent(@Valid @RequestBody StudentRequest request)
            throws UserNotFoundException {
        Student student = StudentMapper.convertStudentRequest(request);
        return new ResponseEntity<>(
                new ObjectResponse(true, Constants.STUDENT_CREATED, studentService.saveStudent(student)),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjectResponse> updateDepartment(@PathVariable("id") @Valid Integer id,
                                                 @Valid @RequestBody DepartmentRequest request)
            throws UserNotFoundException{
        Department department = DepartmentMapper.convertDepartmentRequestWithID(request, id);
        return ResponseEntity.ok(
                new ObjectResponse(true, Constants.DEPARTMENT_UPDATED, DepartmentMapper.convertDepartmentWithoutStudentDTO(departmentService.update(department))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectResponse> getById(@PathVariable("id") @Valid Integer id) {
        Department department = departmentService.getByID(id);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.DEPARTMENT_FOUND, department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") @Valid Integer id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(true, Constants.DEPARTMENT_DELETED));
    }
    @GetMapping("/students")
    public ResponseEntity<ObjectResponse> getAllStudents(@RequestParam(required = false) Integer departmentId,
                                                         @RequestParam(required = false)Integer semesterId,
                                                         @RequestParam(required = false) Integer year) {
        List<Student> students ;
        if(departmentId != null) {
            students = studentService.getAllStudentsByDepartment(departmentId);
        } else if (semesterId != null) {
            students = studentService.getAllStudentsBySemester(semesterId);
        } else if (year != null) {
            students = studentService.getAllStudentsByYear(year);
        } else {
            students = studentService.getAllStudents();
        }
        return ResponseEntity.ok(new ObjectResponse(true, "", students));
    }

    @GetMapping("/{departmentId}/students/{studentId}")
    public ResponseEntity<ObjectResponse> getStudentById(@PathVariable("departmentId") @Valid Integer departmentId,
                                                      @PathVariable("studentId") @Valid Integer studentId) {
        Department department = departmentService.getByID(departmentId);
        Student student = studentService.getById(studentId);
        student.setDepartment(department);
        StudentDTO studentDTO = StudentMapper.convertStudentToStudentDTO(student, department);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.STUDENT_FOUND, studentDTO));
    }

    @PutMapping("/{departmentId}/students/{studentId}")
    public ResponseEntity<ObjectResponse> updateStudent(@PathVariable("studentId") @Valid Integer studentId,
                                                     @PathVariable("departmentId") @Valid Integer departmentId,
                                                     @Valid @RequestBody StudentRequest studentRequest)
            throws UserNotFoundException {
        Student student = StudentMapper.convertStudentRequestWithOutSemesterID(departmentId, studentId, studentRequest);
        return ResponseEntity.ok(
                new ObjectResponse(true, Constants.STUDENT_UPDATED,StudentMapper.convertStudentRequestWithoutDepartmentDTO(studentService.update(student))));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponse> deleteStudentID(@PathVariable("studentId") @Valid Integer id) {
        studentService.deleteByStudentId(id);
        return ResponseEntity.ok(new ApiResponse(true, Constants.STUDENT_DELETED));
    }

}
