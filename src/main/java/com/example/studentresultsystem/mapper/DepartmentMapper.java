package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.DepartmentRequest;
import com.example.studentresultsystem.dto.DepartmentWithOutStudentDTO;
import com.example.studentresultsystem.dto.DepartmentWithStudentDTO;
import com.example.studentresultsystem.dto.StudentDTO;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public final class DepartmentMapper {

    private DepartmentMapper() {
    }
    public static Department convertDepartmentRequest(DepartmentRequest request) {
        return new Department( 0, request.getName());
    }
    public static Department convertDepartmentRequestWithID(DepartmentRequest request, int id) {
        return new Department( id, request.getName());

    }
    public static DepartmentWithStudentDTO convertDepartmentWithStudentDTO(Department department) {

        List<StudentDTO> studentDTOs = department.getStudents().stream()
                .map(DepartmentMapper::convertStudentoStudentDTO)
                .collect(Collectors.toList());

        return new DepartmentWithStudentDTO(
                department.getId(),
                department.getName(),
                studentDTOs
        );
    }

    public static DepartmentWithOutStudentDTO convertDepartmentWithoutStudentDTO(Department department) {
        return new DepartmentWithOutStudentDTO(
                department.getId(),
                department.getName()
        );
    }

    public static List<DepartmentWithOutStudentDTO> convertDepartmentWithoutStudentDTO(List<Department> departmentList) {
        return departmentList.stream()
                .map(DepartmentMapper::convertDepartmentWithoutStudentDTO)
                .collect(Collectors.toList());
    }

    private static StudentDTO convertStudentoStudentDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getGrade(),
                student.getGender(),
                student.getRollNumber()
        );
    }

}
