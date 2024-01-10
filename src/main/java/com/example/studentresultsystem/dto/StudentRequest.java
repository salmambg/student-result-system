package com.example.studentresultsystem.dto;

import com.example.studentresultsystem.entity.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "student name should not be null")
    private String name;
    @NotBlank(message = "Roll number should not be blank")
    @Pattern(regexp = "^\\d{8}$", message = "Invalid roll number (8 digits required)")
    private String rollNumber;
    @NotNull(message = "Department should not be null")
    private List<Department> departments = new ArrayList<>();
    private String gender;
    private char grade;


}
