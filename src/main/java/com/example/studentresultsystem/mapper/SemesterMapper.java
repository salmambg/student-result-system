package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.ssdto.SemesterRequest;
import com.example.studentresultsystem.dto.ssdto.SemesterWithOutSubjectDTO;
import com.example.studentresultsystem.entity.Semester;

import java.util.ArrayList;
import java.util.List;

public final class SemesterMapper {
    private SemesterMapper() {
    }
    public static Semester convertSemesterRequest(SemesterRequest request) {
        return new Semester(0, request.getName());
    }
    public static Semester convertSemesterRequestWithID(SemesterRequest request, int id) {
        return new Semester(id, request.getName());
    }
    public static SemesterWithOutSubjectDTO convertSemesterWithoutSubjectDTO(Semester semester) {
        return new SemesterWithOutSubjectDTO(
                semester.getId(),
               semester.getName());
    }
    public static List<SemesterWithOutSubjectDTO> convertSemesterwithoutSubjectDTOList(List<Semester> semesters) {
        List<SemesterWithOutSubjectDTO> convertedSemesters = new ArrayList<>();
        for (Semester semester : semesters) {
            convertedSemesters.add(convertSemesterWithoutSubjectDTO(semester));
        }

        return convertedSemesters;
    }

}
