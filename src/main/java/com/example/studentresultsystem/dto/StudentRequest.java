package com.example.studentresultsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "student name should not be null")
    private String name;
    @NotBlank(message = "Roll number should not be blank")
    @Pattern(regexp = "^\\d{8}$", message = "Invalid roll number (8 digits required)")
    private Integer rollNumber;
    private String gender;
    private char grade;


}
