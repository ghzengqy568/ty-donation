package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 捐赠记录扩展详情
 */
@Data
@Schema(description = "捐赠记录扩展详情")
@Builder
public class DonateFlatDetail {

    /**
     * 捐赠流水ID
     */
    @Schema(description = "捐赠流水ID")
    private Long donateFlowId;

    /**
     * 捐赠明细ID
     */
    @Schema(description = "捐赠明细ID")
    private Long donateDetailId;

    /**
     * 捐赠人名称, 可能为匿称
     */
    @Schema(description = "捐赠人名称, 可能为匿称")
    private String donorName;

    /**
     * 捐赠时间
     */
    @Schema(description = "捐赠时间")
    private Date donateTime;

    /**
     * 证书ID
     */
    @Schema(description = "证书ID")
    private String certCode;


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
