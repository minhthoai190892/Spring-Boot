package com.example.rest03createacontroller.controller;

import com.example.rest03createacontroller.entity.Department;
import com.example.rest03createacontroller.repository.DepartmentRepository;
import com.example.rest03createacontroller.respone.DepartmentReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")//http://localhost:8080/api/v1/
public class DepartmentController {

    private DepartmentRepository departmentRepository;

    @Autowired

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    //http://localhost:8080/api/v1/departments
    public List<DepartmentReponse> getDepartmentReponses() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentReponse> departmentReponses = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentReponse departmentReponse = new DepartmentReponse();
            departmentReponse.setDepartmentName(department.getName());
            departmentReponse.setId(department.getId());
            departmentReponse.setEmployeeName(department.getEmployee().getName());
            departmentReponses.add(departmentReponse);
        });

        return departmentReponses;
    }
}
