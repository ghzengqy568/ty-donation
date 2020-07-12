/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "受捐人对象", name = "DonatoryReq")
@Data
public class DonatoryReq {

    @Schema(description = "受赠人用户名")
    private String userName;

    @Schema(description = "受赠人密码")
    private String password;

    @Schema(description = "受赠人名称")
    private String name;

    @Schema(description = "身份证号码")
    private String idcard;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "受赠人社保卡")
    private String donatoryCard;

    @Schema(description = "省份")
    private String province;

    @Schema(description = "城市")
    private String city;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入")
    private Byte donatoryLevel;
}
