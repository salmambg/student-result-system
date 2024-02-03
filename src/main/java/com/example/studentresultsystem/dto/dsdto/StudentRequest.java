package com.example.studentresultsystem.dto.dsdto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor()
@NoArgsConstructor
public class StudentRequest {

    @NotNull(message = "student name should not be null")
    private String name;
    private String grade;
    private String gender;
    @NotNull(message = "Roll number should not be null")
    private Integer rollNumber;

}
