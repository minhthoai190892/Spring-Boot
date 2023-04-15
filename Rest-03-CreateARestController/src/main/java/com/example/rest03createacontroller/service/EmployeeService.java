package com.example.rest03createacontroller.service;

import com.example.rest03createacontroller.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee saveEmployee(Employee employee);
    Employee getSingleEmployee(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeeByNameAndLocation(String name,String location);
    List<Employee> getEmployeesByKeyword(String name);

}
