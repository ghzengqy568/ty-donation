package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "捐赠流水")
@Builder
public class AllDonationFlowResp {

    /**
     * 捐赠人名称
     */
    @Schema(description = "捐赠人名称")
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
     * 参与类型： 捐赠/受捐
     */
    @Schema(description = "参与类型")
    private String participation;

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
