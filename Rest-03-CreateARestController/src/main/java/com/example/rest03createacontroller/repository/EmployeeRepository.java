package com.example.rest03createacontroller.repository;

import com.example.rest03createacontroller.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByName(String name);

    //    select * from table where name="key" and location="key";
    List<Employee> findByNameAndLocation(String name, String location);

    //    select * from table where name like "%key%"
    List<Employee> findByNameContaining(String name, Sort sort);

    Optional<Employee> findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);

    @Query("From Employee where name=:name or location =:location")
    List<Employee> getEmployeesByNameOrLocation(String name, String location);

    @Transactional
    @Modifying
    @Query("delete FROM Employee where name=:name")
    Integer deleteEmployeeByName(String name);

    @Query("from Employee where department.name=:name")
    List<Employee> findByDepartment(String name);
}
