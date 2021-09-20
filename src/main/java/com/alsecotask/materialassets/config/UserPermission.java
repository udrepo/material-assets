package com.alsecotask.materialassets.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserPermission {
    ASSET_READ("asset:read"),
    ASSET_WRITE("asset:write"),
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write");

    private final String permission;

}
