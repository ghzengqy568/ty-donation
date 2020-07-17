package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 受捐领取摘要
 */
@Data
@Schema(description = "受捐领取摘要")
@Builder
public class DCDrawRecordResp {

    /**
     * 领取流水ID
     */
    @Schema(description = "领取流水ID")
    private Long drawFlowId;

    /**
     * 受捐人ID
     */
    @Schema(description = "受捐人ID")
    private Long donatoryId;

    /**
     * 捐赠人名称
     */
    @Schema(description = "受捐人名称")
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
     * 领取详情
     */
    @Schema(description = "领取详情")
    private List<DrawRecordFlatDetail> dcDrawDetailRespList;


}
