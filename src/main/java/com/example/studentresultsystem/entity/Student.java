package com.example.studentresultsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private char grade;
    private String gender;
    @Column(unique = true)
    private Integer rollNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "student_department",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;

    public Student(int id, String name, char grade, String gender, Integer rollNumber) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.rollNumber = rollNumber;
    }

}
