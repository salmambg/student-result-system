package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.TestData;
import com.example.studentresultsystem.entity.Semester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class SemesterRepositoryTest {
    @Autowired
    private SemesterRepository semesterRepository;

    @Test
    public void findAll_successful() {
        Semester semester = TestData.createSemester();
        semesterRepository.save(semester);
        assertEquals(1, List.of(semesterRepository.findAll()).size());

    }
}
