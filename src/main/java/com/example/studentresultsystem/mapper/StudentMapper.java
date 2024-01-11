package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.StudentRequest;
import com.example.studentresultsystem.entity.Student;

public final class StudentMapper {

    private StudentMapper() {
    }
    public static Student convertStudentRequest(StudentRequest request) {
        return new Student( 0, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber());
    }
    public static Student convertStudentRequestWithID(StudentRequest request, int id) {
        return new Student( id, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber());
    }

}
