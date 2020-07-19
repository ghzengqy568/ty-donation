package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "活动计划响应")
@Builder
public class ActivityResp {

    /**
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long id;

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

    @Schema(description = "活动状态， 0-待拨款， 1-已拨款，2-已指派，3-领取中， 4-已结束")
    private Byte status;

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
    @Schema(description = "活动计划详情列表")
    List<ActivityPlanResp> activityPlanRespList;

}
