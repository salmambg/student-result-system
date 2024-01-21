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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    @ToString.Exclude
    private Department department;
}
