/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "受捐人活动对象")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DonatoryActivityRes {

    @Schema(description = "活动ID")
    private Long activityId;

    @Schema(description = "活动主题")
    private String theme;

    @Schema(description = "活动描述")
    private String description;

    @Schema(description = "活动开始时间")
    private Date startTime;

    @Schema(description = "活动结束时间")
    private Date endTime;

    @Schema(description = "证书编码")
    private String certCode;

    @Schema(description = "活动状态， 0-待实施， 1-实施中， 2-实施完成")
    private Byte status;

    @Schema(description = "受捐人Id")
    private Long donatoryId;

    @Schema(description = "领取金额")
    private Long recipientAmount;

    @Schema(description = "领取状态， 0-未领取， 1-已领取")
    private Byte drawStatus;

    @Schema(description = "领取时间")
    private Date drawDate;
}
