package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Long countAssetByEmployee_Id(Long id);

    @Query(value="SELECT employee.id, employee.first_name, sum(asset.price), count(asset.price)\n" +
            "FROM employee LEFT JOIN asset\n" +
            "ON employee.id = asset.employee_id group by employee.id", nativeQuery = true)
    List<Object[]> getAssetsByEmployee();

    @Query(value = "SELECT * FROM Asset WHERE name = ?1", nativeQuery = true)
    Asset findByNameQuery(String name);
}


