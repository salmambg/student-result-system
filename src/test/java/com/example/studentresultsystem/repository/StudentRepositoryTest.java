package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.TestData;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
     private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void findAll_successful() {
        Department department = TestData.createDepartment();
        departmentRepository.save(department);

        Student student = TestData.createStudent();
        studentRepository.save(student);
        assertEquals(1, List.of(studentRepository.findAll()).size());
    }
}
