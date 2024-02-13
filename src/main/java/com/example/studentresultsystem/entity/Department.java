package com.example.studentresultsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany (mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student>students;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
