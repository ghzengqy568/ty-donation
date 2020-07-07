/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "捐赠人注册对象", name = "DonorReq")
@Data
public class DonorReq {

    @Schema(description = "用户名", maxLength = 60, minLength = 5)
    private String userName;

    @Schema(description = "用户密码", maxLength = 20, minLength = 6)
    private String password;

    @Schema(description = "姓名", maxLength = 60, minLength = 2)
    private String name;

}
