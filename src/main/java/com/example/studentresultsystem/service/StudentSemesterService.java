package com.example.studentresultsystem.service;


import com.example.studentresultsystem.dto.dsdto.StudentSemesterRequest;

public interface StudentSemesterService {
    void saveSemesterInStudent(StudentSemesterRequest request);
}
