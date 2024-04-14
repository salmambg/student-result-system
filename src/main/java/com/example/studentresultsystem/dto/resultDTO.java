package com.example.studentresultsystem.dto;

import com.example.studentresultsystem.dto.dsdto.StudentDTO;
import com.example.studentresultsystem.dto.ssdto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class resultDTO {
    private int id;
    private int passingMark;
    private StudentDTO student;
    private SubjectDTO subject;

}
