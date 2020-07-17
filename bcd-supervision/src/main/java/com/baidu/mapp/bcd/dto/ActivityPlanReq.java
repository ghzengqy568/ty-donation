package com.baidu.mapp.bcd.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "活动计划")
public class ActivityPlanReq {

    /**
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;

    /**
     * 计划描述
     */
    @Schema(description = "计划描述")
    private String description;

    /**
     * 捐赠类别, 1-钱，2-物
     */
    @Schema(description = "捐赠类别, 1-钱，2-物")
    private Byte type;

    /**
     * 单位
     */
    @Schema(description = "单位")
    private String unit;

    /**
     * 数量
     */
    @Schema(description = "数量")
    private Long quantity;

    /**
     * 物资名称
     */
    @Schema(description = "物资名称")
    private String name;

    /**
     * 总价
     */
    @Schema(description = "总价")
    private Long amount;

    /**
     * 是否需要采购
     */
    @Schema(description = "是否需要采购")
    private Byte needPurchase;

    @Schema(description = "计划配置")
    private List<ActivityPlanConfigReq> configs;

}
