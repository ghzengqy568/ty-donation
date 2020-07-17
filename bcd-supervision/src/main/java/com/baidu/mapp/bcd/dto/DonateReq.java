/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "捐赠")
public class DonateReq {

    /**
     * 可能是管理员/捐赠人本人
     */
    @Schema(description = "捐赠操作人ID")
    private Long loginId;

    @Schema(description = "捐赠人ID")
    private Long donorId;

    @Schema(description = "捐赠详情")
    List<DonateDetailReq> details;

    @Schema(description = "是否需要匿名捐赠,1-是,0-否")
    private Byte isAnonymous;

}
