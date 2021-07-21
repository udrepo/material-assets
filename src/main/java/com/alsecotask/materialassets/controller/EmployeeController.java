package com.alsecotask.materialassets.controller;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.model.EmployeeAsset;
import com.alsecotask.materialassets.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {

    private  final EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeService.getEmployee(pageable);
    }

    @GetMapping("/assets")
    public Page<EmployeeAsset> getEmployeeAssets(Pageable pageable) {
        return employeeService.getEmployeeAssets(pageable);
    }

    @GetMapping("/assets/{id}")
    public Object geyEmployeeAssetsById(@PathVariable (value = "id") String id) {
        return employeeService.getEmployeeAssetsById(id);
    }


    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PostMapping("/all")
    public void addAllEmployee(@RequestBody List<Employee> employee){
        employeeService.addAllEmployee(employee);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable (value = "id") String id) {
        employeeService.deleteEmployeeById(id);
    }
}
