package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 整个从捐赠到受捐的追溯详情
 */
@Data
@Schema(description = "整个从捐赠到受捐的追溯详情")
@Builder
public class DonateChainResp {

    /**
     * 捐赠流水ID
     */
    @Schema(description = "捐赠流水ID")
    private Long donateFlowId;

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

    @Schema(description = "是否需要匿名捐赠,1-是,0-否")
    private Byte isAnonymous;

    /**
     * 匿名名称
     */
    @Schema(description = "匿名名称")
    private String anonymity;

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
     * 捐赠详情
     */
    @Schema(description = "捐赠详情")
    private List<DonateDetailResp> donateDetailResp;

    /**
     * 捐赠被用于哪些活动列表
     */
    @Schema(description = "活动列表")
    private List<DCActivityBriefResp> activityBriefResps;

}
