package com.example.studentresultsystem.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponse extends ApiResponse {

    private Object object;

    public ObjectResponse(boolean success, String message, Object object) {
        super(success, message);
        this.object = object;
    }
}
