package com.alsecotask.materialassets.controller;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/asset")
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public List<Asset> getAsset() {
        return assetService.getAsset();
    }

    @GetMapping("/count")
    public long getCount() {
        return assetService.getCount();
    }

    @GetMapping("/count/{id}")
    public Long getCountById(@PathVariable (value = "id") Long id) {
        return assetService.getCountById(id);
    }

    @GetMapping("/{name}")
    public Asset getByName(@PathVariable (value = "name") String name) {
        return assetService.findByName(name);
    }

    @GetMapping("/employee-assets")
    public List<Object[]> getAssetsByEmployee() {
        System.out.println(assetService.getAssetsByEmployee());
        return assetService.getAssetsByEmployee();
    }

    @PostMapping
    public void addEmployee(@RequestBody Asset asset) {
        assetService.addAsset(asset);
    }
}
