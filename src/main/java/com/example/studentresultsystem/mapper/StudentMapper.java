package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.dsdto.StudentDTO;
import com.example.studentresultsystem.dto.dsdto.StudentRequest;
import com.example.studentresultsystem.dto.dsdto.StudentWithoutDepartmentDTO;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Student;

public final class StudentMapper {

    private StudentMapper() {
    }
    public static Student convertStudentRequest(StudentRequest request) {
        Department department = new Department();
        department.setId(request.getDepartmentId());
        Semester semester = new Semester();
        semester.setId(request.getSemesterId());
        return new Student(null, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber(),request.getYear(), request.isCompletedBachelor(), department,semester);
    }

    public static Student convertStudentRequestWithID( Integer departmentID, Integer studentID,Integer semesterId, StudentRequest request) {
        Department department = new Department();
        department.setId(departmentID);
        Semester semester = new Semester();
        semester.setId(semesterId);
        return new Student( studentID, request.getName(),request.getGrade(),request.getGender(),request.getRollNumber(),request.getYear(), request.isCompletedBachelor(), department,semester);
    }
    public static Student convertStudentRequestWithOutSemesterID( Integer departmentID, Integer studentID, StudentRequest request) {
        Department department = new Department();
        department.setId(departmentID);
        return new Student( studentID, request.getName(),request.getGrade(),request.getGender(),
                request.getRollNumber(),request.getYear(), request.isCompletedBachelor(), department);
    }

    public static StudentWithoutDepartmentDTO convertStudentRequestWithoutDepartmentDTO(Student student) {
        return new StudentWithoutDepartmentDTO(
                student.getId(),
                student.getName(),
                student.getGrade(),
                student.getGender(),
                student.getRollNumber(),
                student.getYear(),
                student.isCompletedBachelor());

    }

    public static StudentDTO convertStudentToStudentDTO(Student student, Department department) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getGrade(),
                student.getGender(),
                student.getRollNumber(),
                student.getYear(),
                student.isCompletedBachelor(),
                DepartmentMapper.convertDepartmentWithoutStudentDTO(department));
    }

}
