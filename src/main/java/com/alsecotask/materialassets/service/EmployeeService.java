package com.alsecotask.materialassets.service;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.model.EmployeeAsset;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getAllEmployeeWithAssets() {
        return employeeRepository.findAllByAssetsContains();
    }


    public Employee getEmployeeById(String id){
        return employeeRepository.findById(id);
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


    public String
    updateEmployeeById(String id){
        employeeRepository.deleteEmployeeById(id);
        employeeRepository.deleteEmployeeByIdCustom(id);
        return "Updated Successfully";
    }

    public String deleteEmployeeById(String id){
        employeeRepository.deleteEmployeeById(id);
        employeeRepository.deleteEmployeeByIdCustom(id);
        return "Deleted Successfully";
    }

    public String updateEmployeeAsset(){
        employeeRepository.updateAsset();
        return "Updated successfully";
    }



}
