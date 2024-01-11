package com.example.studentresultsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentWithStudentDTO {
    private int id;
    private String name;
    private List<StudentDTO> students;
}
