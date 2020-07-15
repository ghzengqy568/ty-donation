package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 整个从受捐到捐赠的追溯详情
 */
@Data
@Schema(description = "整个从受捐到捐赠的追溯详情")
@Builder
public class DonatoryChainResp {

    /**
     * 领取流水ID
     */
    @Schema(description = "领取流水ID")
    private Long drawRecordFlowId;

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
     * 追溯活动详情
     */
    @Schema(description = "追溯活动详情")
    private DCActivityBriefResp activityBriefResp;


}
