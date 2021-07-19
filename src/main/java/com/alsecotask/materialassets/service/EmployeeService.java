package com.alsecotask.materialassets.service;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee){
        System.out.println(employee.getFName());
    }
}
