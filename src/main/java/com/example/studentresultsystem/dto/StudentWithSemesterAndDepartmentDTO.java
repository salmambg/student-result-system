package com.example.studentresultsystem.dto;

import com.example.studentresultsystem.dto.dsdto.DepartmentWithOutStudentDTO;
import com.example.studentresultsystem.dto.ssdto.SemesterWithOutSubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithSemesterAndDepartmentDTO {
    private int id;
    private String name;
    private String grade;
    private String gender;
    private Integer rollNumber;
    private Integer year;
    private boolean completedBachelor;
    private DepartmentWithOutStudentDTO department;
    private List<SemesterWithOutSubjectDTO> semesters;
}
