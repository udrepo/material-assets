package com.alsecotask.materialassets.service;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.repository.AssetRepository;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;
    public List<Asset> getAsset() {
        return assetRepository.findAll();
    }

    public long getCount(){
        return assetRepository.count();
    }

    public Long getCountById(Long id){
        return assetRepository.countAssetByEmployee_Id(id);
    }
//
//    public List<?> getAssetsByEmployee(){
//       return assetRepository.getAssetsByEmployee();
//    }

    public Asset findByName(String name){
       return assetRepository.findByNameQuery(name);
    }
    public void addAsset(Asset asset){
        assetRepository.save(asset);
    }

}
