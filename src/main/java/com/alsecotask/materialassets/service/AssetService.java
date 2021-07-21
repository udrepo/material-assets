package com.alsecotask.materialassets.service;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.repository.AssetRepository;
import com.alsecotask.materialassets.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;
    public Page<Asset> getAsset(Pageable pageable) {

        return assetRepository.findAll(pageable);
    }

    public long getCount(){
        return assetRepository.count();
    }

//    public Long getCountById(Long id){
//        return assetRepository.countAssetByEmployee_Id(id);
//    }

    public Asset findByName(String name){
       return assetRepository.findByNameQuery(name);
    }
    public void addAsset(Asset asset){
        assetRepository.save(asset);
    }
    public void addAllAsset(List<Asset> asset){
        assetRepository.saveAll(asset);
    }

}
