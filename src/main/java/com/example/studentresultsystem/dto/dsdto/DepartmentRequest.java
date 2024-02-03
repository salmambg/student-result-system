package com.example.studentresultsystem.dto.dsdto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull(message = "department name should not be null")
    private String name;

}
