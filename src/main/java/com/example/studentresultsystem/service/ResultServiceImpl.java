package com.example.studentresultsystem.service;

import com.example.studentresultsystem.repository.StudentRepository;
import com.example.studentresultsystem.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultServiceImpl implements ResultService {
    private static final Logger LOG = LoggerFactory.getLogger(ResultServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;


}
