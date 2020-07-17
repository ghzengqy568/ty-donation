package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "捐赠流水")
@Builder
public class DonateFlowResp {

    /**
     * 捐赠流水ID
     */
    @Schema(description = "捐赠流水ID")
    private Long id;

    /**
     * 捐赠人ID
     */
    @Schema(description = "捐赠人ID")
    private Long donorId;

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

}
