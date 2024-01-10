package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    default Department findByDepartmentId(int id) {
        return null;
    }
}
