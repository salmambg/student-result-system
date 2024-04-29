package com.example.studentresultsystem.service;

import com.example.studentresultsystem.entity.Result;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.entity.Subject;
import com.example.studentresultsystem.repository.ResultRepository;
import com.example.studentresultsystem.request.StuSubResRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResultServiceImpl implements ResultService {
    private static final Logger LOG = LoggerFactory.getLogger(ResultServiceImpl.class);

    @Autowired
    StudentService studentService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    ResultRepository resultRepository;

    @Override
    @Transactional
    public Map<String, Object> getStudentResultWithGrade(StuSubResRequest stuSubResRequest) {
        Student student = studentService.getById(stuSubResRequest.getStudentId());
        Subject subject = subjectService.getByID(stuSubResRequest.getSubjectId());

        String grade = calculateGrade(stuSubResRequest.getMarks());
        Result result = new Result();
        result.setMark(stuSubResRequest.getMarks());
        result.setStudent(student);
        result.setSubject(subject);
        resultRepository.save(result);

        Map<String, Object> response = new HashMap<>();
        response.put("subjectName", subject.getName());
        response.put("grade", grade);
        return response;
    }

    private String calculateGrade(int marks) {
        if (marks >= 80) {
            return "A+";
        } else if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }
    }






}
