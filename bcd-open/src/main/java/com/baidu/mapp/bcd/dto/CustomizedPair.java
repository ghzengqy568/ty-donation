package com.baidu.mapp.bcd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * 键值对, 为了前端易展示, <key,value> -> <value,label>
 */
@Data
@Schema(description = "键值对")
@Builder
public class CustomizedPair {

    @Schema(description = "label")
    private String label;

    @Schema(description = "value")
    private Long value;

}
