/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import com.baidu.mapp.bcd.domain.Donor;

public class UserThreadLocal {
    private static ThreadLocal<Donor> donorThreadLocal = new ThreadLocal<>();

    public static void addDonor(Donor donor) {
        donorThreadLocal.set(donor);
    }

    public static void removeDonor() {
        donorThreadLocal.remove();
    }

    public static Donor getDonor() {
        return donorThreadLocal.get();
    }

}

