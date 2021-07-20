package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    Long countAssetByEmployee_Id(Long id);

//    @Query("SELECT Employee.id, Employee.firstName, sum(Asset .price), count(Asset .price)\n" +
//            "FROM Asset \n" +
//            "         LEFT JOIN Employee \n" +
//            "                   ON Employee .id = Asset .employee.id group by Employee .id\n")
//    List<?> getAssetsByEmployee();

    @Query(value = "SELECT * FROM Asset WHERE name = ?1", nativeQuery = true)
    Asset findByNameQuery(String name);
}


