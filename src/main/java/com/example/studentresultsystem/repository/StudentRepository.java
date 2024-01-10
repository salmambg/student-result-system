package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    default Student findByStudentId(int id) {
        return null;
    }
}
