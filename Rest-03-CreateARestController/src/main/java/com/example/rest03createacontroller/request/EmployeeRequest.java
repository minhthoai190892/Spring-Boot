package com.example.rest03createacontroller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private Long age;
    private String location;
    private String email;
    private String department;
}
