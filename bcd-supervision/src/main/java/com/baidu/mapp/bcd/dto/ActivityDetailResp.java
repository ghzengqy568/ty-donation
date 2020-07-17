package com.baidu.mapp.bcd.dto;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "活动计划响应")
@Builder
public class ActivityDetailResp {

    @Schema(description = "活动ID")
    private Long id;

    @Schema(description = "活动主题")
    private String theme;

    @Schema(description = "活动描述")
    private String description;

    @Schema(description = "活动状态， 0-待实施， 1-实施中， 2-实施完成")
    private Byte status;

    @Schema(description = "活动开始时间")
    private Date startTime;

    @Schema(description = "活动结束时间")
    private Date endTime;

    @Schema(description = "活动计划详情列表")
    List<ActivityPlanDetailResp> plans;

}
