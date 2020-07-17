package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "捐赠流水")
@Builder
public class DonationFlowBriefResp {

    /**
     * 捐赠/受捐人名称
     */
    @Schema(description = "捐赠/受捐人名称")
    private String donorName;


    /**
     * 捐赠/受捐时间
     */
    @Schema(description = "捐赠/受捐时间")
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
     * 捐赠详情
     */
    @Schema(description = "捐赠详情")
    List<DonateDetailResp> donateDetailResps;

}
