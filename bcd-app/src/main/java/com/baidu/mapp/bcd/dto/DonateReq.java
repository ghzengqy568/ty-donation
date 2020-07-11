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

    @Schema(description = "流水uuid", hidden = true)
    private String uuid;

    @Schema(description = "捐赠人ID")
    private String donorUuid;

    @Schema(description = "捐赠详情")
    List<DonateDetailReq> details;



}
