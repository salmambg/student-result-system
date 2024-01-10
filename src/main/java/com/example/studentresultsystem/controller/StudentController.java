package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.dto.StudentRequest;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/signup")
    public ResponseEntity<Student> saveStudent (@RequestBody @Valid StudentRequest studentRequest) throws UserNotFoundException {
        return new ResponseEntity<>(studentService.saveStudent(studentRequest), HttpStatus.CREATED);
    }
    @GetMapping("/fetchAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent (@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(studentService.getStudent(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody @Valid StudentRequest studentRequest) throws UserNotFoundException {
      Student updatedStudent = studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) throws UserNotFoundException {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("delete id successfully :" + id);
    }

}
