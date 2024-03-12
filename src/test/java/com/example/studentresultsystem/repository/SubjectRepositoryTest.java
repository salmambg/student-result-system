package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.TestData;
import com.example.studentresultsystem.entity.Semester;
import com.example.studentresultsystem.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SubjectRepositoryTest {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SemesterRepository semesterRepository;

    @Test
    public void findAll_successful() {
        Semester semester = TestData.createSemester();
        semesterRepository.save(semester);

        Subject subject = TestData.createSubject();
        subjectRepository.save(subject);
        assertEquals(1, List.of(subjectRepository.findAll()).size());
    }
}
