/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "领取对象")
public class DrawReq {

    @Schema(description = "活动ID")
    private Long activityId;

    @Schema(description = "受捐人ID")
    private Long donatoryId;

}
