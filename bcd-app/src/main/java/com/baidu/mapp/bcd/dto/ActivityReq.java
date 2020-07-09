package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "活动")
public class ActivityReq {

    /**
     * 活动主题
     */
    @Schema(description = "活动主题")
    private String theme;

    /**
     * 活动描述
     */
    @Schema(description = "活动描述")
    private String description;

    /**
     * 活动开始时间
     */
    @Schema(description = "活动开始时间")
    private Date startTime;

    /**
     * 活动结束时间
     */
    @Schema(description = "活动结束时间")
    private Date endTime;

    /**
     * 活动计划详情
     */
    @Schema(description = "活动计划详情")
    List<ActivityPlanReq> activityPlanReqList;

}
