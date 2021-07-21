package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AssetRepository extends JpaRepository<Asset, UUID> {

    Page<Asset> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Asset WHERE name = ?1", nativeQuery = true)
    Asset findByNameQuery(String name);
}


