package com.alsecotask.materialassets.repository;

import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssetRepository extends JpaRepository<Asset, Long> {



}

