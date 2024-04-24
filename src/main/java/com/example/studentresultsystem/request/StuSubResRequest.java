package com.example.studentresultsystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuSubResRequest {
    private int marks;
    private int studentId;
    private int subjectId;
}
