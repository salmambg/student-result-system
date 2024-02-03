package com.example.studentresultsystem.dto.ssdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterWithSubjectDTO {
    private int id;
    private String name;
    private List<SubjectDTO> subjects;
}
