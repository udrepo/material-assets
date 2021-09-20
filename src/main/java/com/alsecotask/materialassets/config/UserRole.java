package com.alsecotask.materialassets.config;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.alsecotask.materialassets.config.UserPermission.*;

import java.util.Set;

@AllArgsConstructor
@Getter
public enum UserRole {

    ADMIN(Sets.newHashSet(ASSET_READ, ASSET_WRITE, EMPLOYEE_READ, EMPLOYEE_WRITE));

    private final Set<UserPermission> permissions;

}
