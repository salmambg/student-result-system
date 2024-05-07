package com.example.studentresultsystem.service;

import com.example.studentresultsystem.dto.StudentResultDto;
import com.example.studentresultsystem.request.StuSubResRequest;
import java.util.Map;

public interface ResultService {
    Map<String, Object> getStudentResultWithGrade(StuSubResRequest stuSubResRequest);
    StudentResultDto getResultByStudentId (Integer studentId);
}
