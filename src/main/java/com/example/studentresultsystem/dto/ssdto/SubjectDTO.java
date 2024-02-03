package com.example.studentresultsystem.dto.ssdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private int id;
    private String name;
    private SemesterWithOutSubjectDTO semester;
}
