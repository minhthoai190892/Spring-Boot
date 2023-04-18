package com.example.rest03createacontroller.service;

import com.example.rest03createacontroller.entity.Employee;
import com.example.rest03createacontroller.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    //
//    private static List<Employee> list = new ArrayList<>();
//    static {
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("Employee 1");
//        employee.setAge(29L);
//        employee.setEmail("Employee1@gmail.com");
//        employee.setDepartment("IT");
//        employee.setLocation("CITY");
//        list.add(employee);
//
//         employee= new Employee();
//        employee.setId(2L);
//        employee.setName("Employee 2");
//        employee.setAge(33L);
//        employee.setEmail("Employee2@gmail.com");
//        employee.setDepartment("IT");
//        employee.setLocation("CITY");
//        list.add(employee);
//    }
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
//    public List<Employee> getEmployees() {
//        return employeeRepository.findAll();
//    }

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,"id");

        return employeeRepository.findAll(pages).getContent();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }
     throw new RuntimeException("Employee is not found for the id "+id);

    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
        return employeeRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        return employeeRepository.findByNameContaining(name,sort);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
        return employeeRepository.getEmployeesByNameOrLocation(name,location);
    }

    @Override
    public Integer deleteEmployeeByName(String name) {
        return employeeRepository.deleteEmployeeByName(name);
    }


}
