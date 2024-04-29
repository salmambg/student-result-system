package com.example.studentresultsystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuSubResRequest {
    private Integer marks;
    private Integer studentId;
    private Integer subjectId;
}
