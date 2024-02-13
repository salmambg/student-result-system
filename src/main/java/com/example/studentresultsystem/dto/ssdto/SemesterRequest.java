package com.example.studentresultsystem.dto.ssdto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterRequest {

    @NotNull(message = "semester name should not be null")
    private String name;
}
