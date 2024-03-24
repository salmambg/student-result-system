package com.example.studentresultsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_semester",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "semester_id"))
    private List<Semester> semesters = new ArrayList<>();


    public Student(Integer id, String name, String grade, String gender,Integer year,Boolean completedBachelor ,Department department,List<Semester> semesters) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.year = year;
        this.completedBachelor = completedBachelor;
        this.department = department;
        this.semesters = semesters;

    }

    public Student(Integer id, String name, String grade, String gender, int rollNumber,int year, boolean completedBachelor, Department department) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.rollNumber = rollNumber;
        this.year = year;
        this.completedBachelor = completedBachelor;
        this.department = department;
    }
}
