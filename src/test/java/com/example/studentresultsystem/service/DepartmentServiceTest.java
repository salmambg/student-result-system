package com.example.studentresultsystem.service;

import com.example.studentresultsystem.TestData;
import com.example.studentresultsystem.entity.Department;
import com.example.studentresultsystem.exception.UserNotFoundException;
import com.example.studentresultsystem.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentService departmentService;

    @Mock
    private DepartmentRepository departmentRepository;

    @Test
    public void createDepartment_successful() throws UserNotFoundException {

        Department department = TestData.createDepartment();
        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Department createdDepartment = departmentService.create(department);

        assertEquals(department, createdDepartment);
        assertEquals(department.getName(), createdDepartment.getName());
    }

    @Test
    public void getAll_successful() {

        Department department = TestData.createDepartment();
        List<Department> departmentList = List.of(department);
        given(departmentRepository.findAll()).willReturn(departmentList);

        List<Department> result = departmentService.getAllDepartments();
        assertEquals(1, result.size());
    }

}
