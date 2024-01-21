package com.example.studentresultsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private int id;
    private String name;
    private String grade;
    private String gender;
    private Integer rollNumber;
    private DepartmentWithOutStudentDTO department;
}
