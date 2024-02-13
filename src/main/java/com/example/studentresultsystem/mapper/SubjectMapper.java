package com.example.studentresultsystem.mapper;

import com.example.studentresultsystem.dto.ssdto.SubjectDTO;
import com.example.studentresultsystem.dto.ssdto.SubjectRequest;
import com.example.studentresultsystem.dto.ssdto.SubjectWithoutSemesterDTO;;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Subject;

public final class SubjectMapper {
    private SubjectMapper() {
    }

    public static Subject convertSubjectRequest(int semesterId, SubjectRequest request) {
        Semester semester = new Semester();
        semester.setId(semesterId);
        return new Subject(null, request.getName(), semester);
    }
    public static Subject convertSubjectRequestWithId( Integer semesterID, Integer subjectID, SubjectRequest request) {
        Semester semester = new Semester();
        semester.setId(semesterID);
        return new Subject(subjectID, request.getName(),semester);
    }
    public static SubjectWithoutSemesterDTO convertSubjectRequestWithOutSemesterDTO(Subject subject) {
        return new SubjectWithoutSemesterDTO(
                subject.getId(),
                subject.getName());
    }

    public static SubjectDTO convertSubjectToSubjectDTO(Subject subject, Semester semester) {
        return new SubjectDTO(
                subject.getId(),
                subject.getName(),
                SemesterMapper.convertSemesterWithoutSubjectDTO(semester));
    }

}
