package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 捐赠详情
 */
@Data
@Schema(description = "捐赠详情")
@Builder
public class DonateDetailResp {

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
