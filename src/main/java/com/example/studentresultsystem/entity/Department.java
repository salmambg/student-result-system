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
public class Department {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private List<Student> students = new ArrayList<>();

}
