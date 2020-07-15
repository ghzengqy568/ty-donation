/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginParam {

    @Schema(description = "用户名")
    private String userName;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "密码")
    private String password;

}
