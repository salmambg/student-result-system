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
@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="semester_id", nullable=false)
    @ToString.Exclude
    private Semester semester;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
