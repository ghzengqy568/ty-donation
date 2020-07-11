/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.common.utils;

import com.baidu.mapp.bcd.common.utils.digest.DigestUtils;

public class SignUtils {

    public static String sign(Object ...field) {
        if (field == null || field.length <= 0) {
            throw new IllegalArgumentException("sign fail. param field is empty.");
        }

        StringBuilder sb = new StringBuilder();
        for (Object f : field) {
            sb.append(f == null ? "null" : f.toString()).append(":");
        }
        return DigestUtils.md5DigestAsHex(sb.toString().getBytes());
    }
}
