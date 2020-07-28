package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "捐赠结果前台展现")
@Builder
public class DonateResp {

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
     * 捐赠金额
     */
    @Schema(description = "捐赠金额")
    private Long quantity;

}
