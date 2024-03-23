package com.example.studentresultsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String grade;
    private String gender;
    @Column(unique = true)
    private int rollNumber;
    private int year;
    private boolean completedBachelor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    @ToString.Exclude
    private Department department;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="semester_id", nullable=false)
    @ToString.Exclude
    private Semester semester;

    public Student(Integer id, String name, String grade, String gender,Integer year,Boolean completedBachelor ,Department department,Semester semester) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.year = year;
        this.completedBachelor = completedBachelor;
        this.department = department;
        this.semester = semester;

    }

    public Student(Integer id, String name, String grade, String gender, int rollNumber,int year, boolean completedBachelor, Department department) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.department = department;
    }
}
