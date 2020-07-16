/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.domain.dto;

import org.apache.commons.lang3.StringUtils;

public enum UserType {
    ADMIN("admin"),
    DONOR("donor"),
    DONATORY("donatory");

    private String name;
    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean isAdminToken(String token) {
        return StringUtils.startsWith(token, ADMIN.name.concat(":"));
    }

    public static boolean isDonatoryToken(String token) {
        return StringUtils.startsWith(token, DONATORY.name.concat(":"));
    }

    public static boolean isDonorToken(String token) {
        return StringUtils.startsWith(token, DONOR.name.concat(":"));
    }

    public boolean isAdmin() {
        return ADMIN.equals(this);
    }

    public boolean isDonatory() {
        return DONATORY.equals(this);
    }

    public boolean isDonor() {
        return DONOR.equals(this);
    }

}
