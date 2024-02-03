package com.example.studentresultsystem.dto.dsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithoutDepartmentDTO {
    private int id;
    private String name;
    private String grade;
    private String gender;
    private Integer rollNumber;
}
