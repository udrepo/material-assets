package com.alsecotask.materialassets.config;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.alsecotask.materialassets.config.UserPermission.*;

import java.util.Set;

@AllArgsConstructor
@Getter
public enum UserRole {

    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<UserPermission> permissions;

}
