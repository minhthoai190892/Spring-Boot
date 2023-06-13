package com.example.rest03createacontroller.repository;

import com.example.rest03createacontroller.entity.Department;
import com.example.rest03createacontroller.entity.DepartmentMany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentManyRepository extends JpaRepository<DepartmentMany,Long> {
}
