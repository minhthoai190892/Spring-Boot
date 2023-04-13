package com.example.rest03createacontroller.service;

import com.example.rest03createacontroller.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static List<Employee> list = new ArrayList<>();
    static {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Employee 1");
        employee.setAge(29L);
        employee.setEmail("Employee1@gmail.com");
        employee.setDepartment("IT");
        employee.setLocation("CITY");
        list.add(employee);

         employee= new Employee();
        employee.setId(2L);
        employee.setName("Employee 2");
        employee.setAge(33L);
        employee.setEmail("Employee2@gmail.com");
        employee.setDepartment("IT");
        employee.setLocation("CITY");
        list.add(employee);
    }
    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}
