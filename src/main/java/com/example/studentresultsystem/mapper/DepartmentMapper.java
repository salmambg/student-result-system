package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.dsdto.DepartmentRequest;
import com.example.studentresultsystem.dto.dsdto.DepartmentWithOutStudentDTO;
import com.example.studentresultsystem.entity.Department;

public final class DepartmentMapper {

    private DepartmentMapper() {
    }
    public static Department convertDepartmentRequest(DepartmentRequest request) {
        return new Department( 0, request.getName());
    }
    public static Department convertDepartmentRequestWithID(DepartmentRequest request, int id) {
        return new Department( id, request.getName());

    }

    public static DepartmentWithOutStudentDTO convertDepartmentRequestWithID(Department department) {
        return new DepartmentWithOutStudentDTO(
                department.getId(),
                department.getName());
    }

    public static DepartmentWithOutStudentDTO convertDepartmentWithoutStudentDTO(Department department) {
        return new DepartmentWithOutStudentDTO(
                department.getId(),
                department.getName()
        );
    }

}
