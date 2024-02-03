package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.ssdto.SubjectRequest;
import com.example.studentresultsystem.dto.ssdto.SubjectWithoutSemesterDTO;
import com.example.studentresultsystem.entity.Subject;

public final class SubjectMapper {
    private SubjectMapper() {
    }

    public static Subject convertSubjectRequest(SubjectRequest request) {
        return new Subject( 0, request.getName());
    }
    public static Subject convertSubjectRequestWithID(SubjectRequest request, int id) {
        return new Subject( id, request.getName());

    }
    public SubjectWithoutSemesterDTO convertSubjectRequestWithOutSemester(Subject subject) {
        return new SubjectWithoutSemesterDTO(
                subject.getId(),
                subject.getName());
    }

}
