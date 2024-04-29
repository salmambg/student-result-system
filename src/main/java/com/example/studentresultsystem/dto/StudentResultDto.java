package com.example.studentresultsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResultDto {
    private int id;
    private String name;
    private String grade;
    private String gender;
    private Integer rollNumber;
    private Integer year;
    private boolean completedBachelor;
    List<resultDTO> subjectGrade;
    private double CGPA;
}
