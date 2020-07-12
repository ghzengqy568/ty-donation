package com.baidu.mapp.bcd.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "指派")
public class AssignReq {

    private Long activityId;

    private List<AssignPlanReq> plans;
}
