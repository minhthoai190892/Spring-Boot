package com.example.rest03createacontroller.repository;

import com.example.rest03createacontroller.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    List<Employee> findByName(String name);
//    select * from table where name="key" and location="key";
    List<Employee> findByNameAndLocation(String name,String location);
    //    select * from table where name like "%key%"
    List<Employee> findByNameContaining(String name);

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
