package com.alsecotask.materialassets.controller;


import com.alsecotask.materialassets.model.Asset;
import com.alsecotask.materialassets.model.Employee;
import com.alsecotask.materialassets.service.AssetService;
import com.alsecotask.materialassets.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/asset")
public class AssetController {

    private  final AssetService assetService;

    @GetMapping
    public List<Asset> getAsset() {
        return assetService.getAsset();
    }

}
