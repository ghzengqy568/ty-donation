/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "活动计划配置")
@Builder
public class ActivityPlanConfigResp {
    @Schema(description = "配置ID")
    private Long configId;

    @Schema(description = "受赠人等级，1-绝对贫困人口(年人均纯收入低于627元), 2-相对贫困人口(年人均纯收入628—865元), 3-低收入人口(年人均纯收入866—1205元), 4-一般收入")
    private Byte donatoryLevel;

    @Schema(description = "同等级受捐人受捐数量")
    private Long quantity;

    @Schema(description = "份数")
    private Integer amount;

    @Schema(description = "已指派人数")
    private Long mounted;

}
