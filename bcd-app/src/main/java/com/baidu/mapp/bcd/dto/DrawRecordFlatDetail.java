package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 领取记录扩展详情
 */
@Data
@Schema(description = "领取记录扩展详情")
@Builder
public class DrawRecordFlatDetail {

    /**
     * 领取流水ID
     */
    @Schema(description = "领取流水ID")
    private Long drawFlowId;

    /**
     * 领取时间
     */
    @Schema(description = "领取时间")
    private Date drawTime;

    /**
     * 证书ID
     */
    @Schema(description = "证书ID")
    private String certCode;

    /**
     * 活动ID
     */
    @Schema(description = "活动ID")
    private Long activityId;

    /**
     * 活动计划ID
     */
    @Schema(description = "活动计划ID")
    private Long activityPlanId;

    /**
     * 拨款记录ID
     */
    @Schema(description = "拨款记录ID")
    private Long allocationId;

    /**
     * 受赠人ID
     */
    @Schema(description = "受赠人ID")
    private Long donatoryId;

    /**
     * 受赠人名称
     */
    @Schema(description = "受赠人名称")
    private String donatoryName;

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

}
