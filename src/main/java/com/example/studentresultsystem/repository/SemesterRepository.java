package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,Integer> {
    Optional<Semester> findById(int id);

}
