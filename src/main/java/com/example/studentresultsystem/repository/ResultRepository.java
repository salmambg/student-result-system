package com.example.studentresultsystem.repository;

import com.example.studentresultsystem.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

}
