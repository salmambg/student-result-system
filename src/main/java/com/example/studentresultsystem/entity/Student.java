package com.example.studentresultsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_department",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments = new ArrayList<>();
}
