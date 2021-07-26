package com.alsecotask.materialassets.service;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public Page<Asset> getAsset(Pageable pageable) {
        return assetRepository.findAll(pageable);
    }

    public long getCount() {
        return assetRepository.count();
    }

    public Asset findByName(String name) {
        return assetRepository.findByNameQuery(name);
    }

    public void addAsset(Asset asset) {
        assetRepository.save(asset);
    }

    public void addAllAsset(List<Asset> asset) {
        assetRepository.saveAll(asset);
    }


    public String deleteAssetById(String id){
        assetRepository.deleteAssetById(id);
        return "Deleted Successfully";
    }

    public Optional<Asset> updateAssetById(UUID id, Asset assetRequest){
        return assetRepository.findById(id).map(asset -> {
            asset.setName(assetRequest.getName());
            asset.setPrice(assetRequest.getPrice());
            return assetRepository.save(asset);
        });
    }
}
