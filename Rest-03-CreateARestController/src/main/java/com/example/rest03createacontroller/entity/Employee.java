package com.example.rest03createacontroller.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private int id;
    private String name;
    private Long age;
    private String location;
    private String email;
    private String department;
}
