package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.model.EmployeeAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Page<Employee> findAll(Pageable pageable);

    @Query("select new com.alsecotask.materialassets.model.EmployeeAsset(e .id, e .firstName, e .lastName, sum(a.price), count(a .price)) FROM Employee e join e.assets a group by e.id")
    Page<EmployeeAsset> getEmployeeAssets(Pageable pageable);


//    @Query(value="SELECT new com.alseco.materialassets.model.EmployeeAsset(employee.id, employee.first_name, employee.last_name, sum(asset.price), count(asset.price))\n" +
//            "FROM employee LEFT JOIN asset\n" +
//            "ON employee.id = asset.employee_id group by employee.id", nativeQuery = true)
//    List<EmployeeAsset> getEmployeeAssets(Pageable pageable);

    @Query(value = "SELECT employee.id, employee.first_name, sum(asset.price), count(asset.price)\n" +
            "FROM employee LEFT JOIN asset\n" +
            "ON employee.id = asset.employee_id\n" +
            "WHERE employee.id = ?1 group by employee.id",
            nativeQuery = true)
    List<Object> getEmployeeAssetsById(String id);

    @Transactional
    @Modifying
    @Query(value = "DELETE from asset using employee\n" +
            "where employee.id = asset.employee_id\n" +
            "and asset.employee_id = ?1",
            nativeQuery = true)
    void deleteEmployeeById(String id);

    @Transactional
    @Modifying
    @Query(value = "delete from employee where id = ?1 \n",
            nativeQuery = true)
    void deleteEmployeeByIdCustom(String id);

}
