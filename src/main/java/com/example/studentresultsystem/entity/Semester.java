package com.example.studentresultsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Semester {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "semester", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @JsonManagedReference
    @ManyToMany(mappedBy = "semesters")
    private List<Student> students = new ArrayList<>();
    public Semester(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
