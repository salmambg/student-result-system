package com.example.studentresultsystem.dto.dsdto;

import com.example.studentresultsystem.utils.Constants;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull(message = Constants.NOT_EMPTY_NAME)
    private String name;

}
