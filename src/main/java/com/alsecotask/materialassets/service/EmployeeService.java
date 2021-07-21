package com.alsecotask.materialassets.service;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public List<Object[]> getEmployeeAssets(){
        return employeeRepository.getEmployeeAssets();
    }



    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
}
