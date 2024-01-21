package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.DepartmentWithOutStudentDTO;
import com.example.studentresultsystem.dto.StudentDTO;
import com.example.studentresultsystem.dto.StudentRequest;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;

public final class StudentMapper {

    private StudentMapper() {
    }
    public static Student convertStudentRequest( int departmentID, StudentRequest request) {
        Department department = new Department();
        department.setId(departmentID);
        return new Student(null, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber(), department);
    }

    public static Student convertStudentRequestWithID( Integer departmentID, Integer studentID, StudentRequest request) {
        Department department = new Department();
        department.setId(departmentID);
        return new Student( studentID, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber(),department);
    }

    public static StudentDTO convertStudentToStudentDTO(Student student, Department department) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getGrade(),
                student.getGender(),
                student.getRollNumber(),
                DepartmentMapper.convertDepartmentRequestWithID(department));
    }

}
