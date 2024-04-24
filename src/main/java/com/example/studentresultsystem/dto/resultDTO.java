package com.example.studentresultsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class resultDTO {
    private int id;
    private String subjectName;
    private String grade;
}
