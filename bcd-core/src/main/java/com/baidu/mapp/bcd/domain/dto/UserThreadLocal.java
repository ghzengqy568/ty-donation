/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.domain.dto;

public class UserThreadLocal {
    private static ThreadLocal<LoginUser> donorThreadLocal = new ThreadLocal<>();

    public static void addLoginUser(LoginUser user) {
        donorThreadLocal.set(user);
    }

    public static void removeLoginUser() {
        donorThreadLocal.remove();
    }

    public static LoginUser getLoginUser() {
        return donorThreadLocal.get();
    }

}

