package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 链上捐赠/领取记录详情
 */
@Data
@Schema(description = "链上记录详情")
@Builder
public class Verification {

    /**
     * 业务数据与链上数据校验通过与否
     * true: 校验通过
     * false: 检验不通过
     */
    @Schema(description = "TODO 业务数据与链上数据校验通过与否, true-通过, false-不通过")
    private Boolean pass;

    /**
     * 名称
     */
    @Schema(description = "名称")
    private String donorOrDonatoryName;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idCard;

    /**
     * 捐赠/领取时间
     */
    @Schema(description = "捐赠/领取时间")
    private Date time;

    /**
     * 链上记录详情
     */
    @Schema(description = "链上记录详情")
    List<VerificationDetail> drawVerificationDetailList;

}
