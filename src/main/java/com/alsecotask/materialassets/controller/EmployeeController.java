package com.alsecotask.materialassets.controller;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.model.EmployeeAsset;
import com.alsecotask.materialassets.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {

    private  final EmployeeService employeeService;

    @GetMapping
    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeService.getAllEmployee(pageable);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable (value = "id") String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/withAssets")
    public List<Employee> getAllEmployeeWithAssets() {
        return employeeService.getAllEmployeeWithAssets();
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
    public @ResponseBody String deleteNEmployeeById(@PathVariable (value = "id") UUID id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/upd")
    public @ResponseBody String updateAsset() {
        return employeeService.updateEmployeeAsset();
    }


    @PutMapping("/{id}")
    public Optional<Employee> updateEmployee(@PathVariable UUID id, @RequestBody Employee employeeRequest) {
        return employeeService.updateEmployeeById(id, employeeRequest);
    }
}
