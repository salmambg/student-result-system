package com.example.studentresultsystem.dto.dsdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSemesterRequest {
    private Integer studentId;
    private List<Integer> semestersId;
}
