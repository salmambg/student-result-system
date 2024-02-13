package com.example.studentresultsystem.dto.ssdto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {

    @NotNull(message = "subject name should not be null")
    private String name;
}
