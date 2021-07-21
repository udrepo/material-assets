package com.alsecotask.materialassets.service;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.model.EmployeeAsset;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Page<EmployeeAsset> getEmployeeAssets(Pageable pageable){
        return employeeRepository.getEmployeeAssets(pageable);
    }

    public Object getEmployeeAssetsById(String id){
        return employeeRepository.getEmployeeAssetsById(id);
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public void addAllEmployee(List<Employee> employee){
        employeeRepository.saveAll(employee);
    }


    public void deleteEmployeeById(String id){
        employeeRepository.deleteEmployeeById(id);
        employeeRepository.deleteEmployeeByIdCustom(id);
    }

}
