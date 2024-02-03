package com.example.studentresultsystem.controller;

import com.example.studentresultsystem.service.SemesterService;
import com.example.studentresultsystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSController {
    @Autowired
    SemesterService semesterService;
    @Autowired
    SubjectService subjectService;
}
