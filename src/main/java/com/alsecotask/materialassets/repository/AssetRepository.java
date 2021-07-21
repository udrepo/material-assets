package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query(value = "SELECT * FROM Asset WHERE name = ?1", nativeQuery = true)
    Asset findByNameQuery(String name);
}


