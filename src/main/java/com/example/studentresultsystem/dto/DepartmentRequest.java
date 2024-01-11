package com.example.studentresultsystem.dto;

import com.example.studentresultsystem.entity.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull(message = "department name should not be null")
    private String name;

}
