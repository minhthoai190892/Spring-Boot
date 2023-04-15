package com.example.rest03createacontroller.repository;

import com.example.rest03createacontroller.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByName(String name);
//    select * from table where name="key" and location="key";
    List<Employee> findByNameAndLocation(String name,String location);
}
