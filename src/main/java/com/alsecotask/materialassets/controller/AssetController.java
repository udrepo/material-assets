package com.alsecotask.materialassets.controller;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/asset")
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public Page<Asset> getAsset(Pageable pageable) {
        return assetService.getAsset(pageable);
    }

    @GetMapping("/count")
    public long getCount() {
        return assetService.getCount();
    }


    @GetMapping("/{name}")
    public Asset getByName(@PathVariable (value = "name") String name) {
        return assetService.findByName(name);
    }

    @PostMapping
    public void addAsset(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }

    @PostMapping("/all")
    public void addAllAsset(@RequestBody List<Asset> asset) {
        assetService.addAllAsset(asset);
    }



    @DeleteMapping("/{id}")
    public @ResponseBody String deleteAssetById(@PathVariable (value = "id") String id) {
        return assetService.deleteAssetById(id);
    }

    @PutMapping("/{id}")
    public Optional<Asset> updateAsset(@PathVariable UUID id, @RequestBody Asset assetRequest) {
        return assetService.updateAssetById(id, assetRequest);
    }

}
