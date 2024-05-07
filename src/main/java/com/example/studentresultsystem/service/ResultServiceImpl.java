package com.example.studentresultsystem.service;

import com.example.studentresultsystem.dto.ResultDTO;
import com.example.studentresultsystem.dto.StudentResultDto;
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
import java.util.*;

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
    @Override
    @Transactional
    public StudentResultDto getResultByStudentId (Integer studentId) {
        Student student = studentService.getById(studentId);
        List<Result> results = resultRepository.findByStudentId(studentId);

        List<ResultDTO> resultDTOs = new ArrayList<>();
        double totalGPA = 0.0;
        for (Result result : results) {
            String grade = calculateGrade(result.getMark());

            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setSubjectName(result.getSubject().getName());
            resultDTO.setGrade(grade);
            resultDTOs.add(resultDTO);

            totalGPA += convertGradeToGPA(grade);
        }
        if (!results.isEmpty()) {
            totalGPA /= results.size();
        }

        totalGPA = Double.parseDouble(String.format("%.2f", totalGPA));

        StudentResultDto studentResultDTO = new StudentResultDto();
        studentResultDTO.setId(student.getId());
        studentResultDTO.setName(student.getName());
        studentResultDTO.setGender(student.getGender());
        studentResultDTO.setRollNumber(student.getRollNumber());
        studentResultDTO.setYear(student.getYear());
        studentResultDTO.setCompletedBachelor(student.isCompletedBachelor());
        studentResultDTO.setSubjectGrade(resultDTOs);
        studentResultDTO.setCGPA(totalGPA);

        return studentResultDTO;
    }

    private double convertGradeToGPA(String grade) {
        return switch (grade) {
            case "A+" -> 4.0;
            case "A" -> 3.5;
            case "B" -> 3.0;
            case "C" -> 2.5;
            case "F" -> 2.0;
            default -> 0.0;
        };
    }
}
