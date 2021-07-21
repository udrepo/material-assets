package com.alsecotask.materialassets.controller;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {

    private  final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/assets")
    public List<Object[]> getEmployeeAssets() {
        System.out.println(employeeService.getEmployeeAssets());
        return employeeService.getEmployeeAssets();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

}
