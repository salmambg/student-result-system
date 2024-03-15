package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student>  findById(int id) ;

    List<Student> findByDepartmentId(int departmentId);

    List<Student> findBySemesterId(int semesterId);
}
