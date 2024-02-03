package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.ssdto.SemesterRequest;
import com.example.studentresultsystem.dto.ssdto.SemesterWithOutSubjectDTO;
import com.example.studentresultsystem.entity.Semester;

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



}
