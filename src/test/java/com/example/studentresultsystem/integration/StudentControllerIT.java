package com.example.studentresultsystem.integration;

import com.example.studentresultsystem.TestData;
import com.example.studentresultsystem.dto.dsdto.DepartmentRequest;
import com.example.studentresultsystem.response.ObjectResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    private final String Base_URL = "/departments";
    HttpHeaders headers;

    @BeforeAll
    public void getHeaders() {
        headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    }
    @Test
    public void createDepartmentSuccess() {
        DepartmentRequest departmentRequest = TestData.createDepartmentRequest();
        HttpEntity<DepartmentRequest> request = new HttpEntity<>(departmentRequest,headers);
        ResponseEntity<ObjectResponse> result = restTemplate.postForEntity(Base_URL, request, ObjectResponse.class);
        assertEquals(HttpStatus.CREATED.value(), result.getStatusCodeValue());
    }

}
