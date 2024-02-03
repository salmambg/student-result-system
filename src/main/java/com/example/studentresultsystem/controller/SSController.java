package com.example.studentresultsystem.controller;


import com.example.studentresultsystem.dto.dsdto.DepartmentRequest;
import com.example.studentresultsystem.dto.dsdto.StudentDTO;
import com.example.studentresultsystem.dto.dsdto.StudentRequest;
import com.example.studentresultsystem.dto.ssdto.SemesterRequest;
import com.example.studentresultsystem.dto.ssdto.SubjectDTO;
import com.example.studentresultsystem.dto.ssdto.SubjectRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.entity.Subject;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.mapper.DepartmentMapper;
import com.example.studentresultsystem.mapper.SemesterMapper;
import com.example.studentresultsystem.mapper.StudentMapper;
import com.example.studentresultsystem.mapper.SubjectMapper;
import com.example.studentresultsystem.response.ApiResponse;
import com.example.studentresultsystem.response.ObjectResponse;
import com.example.studentresultsystem.service.SemesterService;
import com.example.studentresultsystem.service.SubjectService;
import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semesters")
public class SSController {
    @Autowired
    SemesterService semesterService;
    @Autowired
    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<ObjectResponse> create(@Valid @RequestBody SemesterRequest request)
            throws UserNotFoundException {
        Semester semester = SemesterMapper.convertSemesterRequest(request);
        return new ResponseEntity<>(
                new ObjectResponse(true, Constants.SEMESTER_CREATED,
                        SemesterMapper.convertSemesterWithoutSubjectDTO(semesterService.create(semester))),
                HttpStatus.CREATED);
    }
    @GetMapping
    public List<Semester> getAllSemesters () {
        return semesterService.getAllSemesters();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ObjectResponse> updateSemester(@PathVariable("id") @Valid Integer id,
                                                           @Valid @RequestBody SemesterRequest request)
            throws UserNotFoundException{
        Semester semester = SemesterMapper.convertSemesterRequestWithID(request, id);
        return ResponseEntity.ok(
                new ObjectResponse(true, Constants.SEMESTER_UPDATED,
                        SemesterMapper.convertSemesterWithoutSubjectDTO(semesterService.update(semester))));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ObjectResponse> getById(@PathVariable("id") @Valid Integer id) {
        Semester semester = semesterService.getByID(id);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.SEMESTER_FOUND, semester));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") @Valid Integer id) {
        semesterService.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(true, Constants.SEMESTER_FOUND));
    }
    @PostMapping("/{semesterId}/subjects")
    public ResponseEntity<ObjectResponse> createSubject(@PathVariable("semesterId") int semesterID,
                                                        @Valid @RequestBody SubjectRequest request)
            throws UserNotFoundException {
        Subject subject = SubjectMapper.convertSubjectRequest(semesterID, request);
        return new ResponseEntity<>(
                new ObjectResponse(true, Constants.SUBJECT_CREATED, subjectService.saveSubject(subject)),
                HttpStatus.CREATED);
    }
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
    @GetMapping("/{semesterId}/subjects/{subjectId}")
    public ResponseEntity<ObjectResponse> getSubjectById(@PathVariable("semesterId") @Valid Integer semesterId,
                                                         @PathVariable("subjectId") @Valid Integer subjectId) {
        Semester semester = semesterService.getByID(semesterId);
        Subject subject = subjectService.getByID(subjectId);
        subject.setSemester(semester);
        SubjectDTO subjectDTO = SubjectMapper.convertSubjectToSubjectDTO(subject, semester);
        return ResponseEntity.ok(new ObjectResponse(true, Constants.SUBJECT_FOUND, subjectDTO));
    }
    @PutMapping("/{semesterId}/subjects/{subjectId}")
    public ResponseEntity<ObjectResponse> updateSubject(@PathVariable("semesterId") @Valid Integer subjectId,
                                                        @PathVariable("subjectId") @Valid Integer semesterId,
                                                        @Valid @RequestBody SubjectRequest subjectRequest)
            throws UserNotFoundException {
        Subject subject = SubjectMapper.convertSubjectRequestWithId(semesterId, subjectId, subjectRequest);
        return ResponseEntity.ok(
                new ObjectResponse(true, Constants.SUBJECT_UPDATED,
                        SubjectMapper.convertSubjectRequestWithOutSemesterDTO(subjectService.update(subject))));
    }
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ApiResponse> deleteSubjectID(@PathVariable("subjectId") @Valid Integer id) {
        subjectService.deleteBySubjectId(id);
        return ResponseEntity.ok(new ApiResponse(true, Constants.SUBJECT_DELETED));
    }

}
