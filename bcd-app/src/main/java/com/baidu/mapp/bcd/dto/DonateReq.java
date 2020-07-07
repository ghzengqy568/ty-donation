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

    @Schema(description = "捐赠")
    private Long id;

    @Schema(description = "捐赠人ID")
    private Long donorId;

    List<DonateDetailReq> details;

}
