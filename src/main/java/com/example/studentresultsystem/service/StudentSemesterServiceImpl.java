package com.example.studentresultsystem.service;

import com.example.studentresultsystem.dto.dsdto.StudentSemesterRequest;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Student;
import com.example.studentresultsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentSemesterServiceImpl implements StudentSemesterService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SemesterService semesterService;

    @Override
    @Transactional
    public void saveSemesterInStudent(StudentSemesterRequest request) {
        Student student = studentService.getById(request.getStudentId());
        List<Semester> semesters = new ArrayList<>();
        for (int semesterId: request.getSemestersId()) {
            Semester semester = semesterService.getByID(semesterId);
            semesters.add(semester);
        }
        student.getSemesters().addAll(semesters);
        studentRepository.save(student);
    }
}
