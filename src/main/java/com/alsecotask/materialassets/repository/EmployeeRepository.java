package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
