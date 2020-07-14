/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private Long userId;
    private String token;
}
