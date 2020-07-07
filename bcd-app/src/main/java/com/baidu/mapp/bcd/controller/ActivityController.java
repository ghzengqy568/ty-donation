/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.domain.Activity;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.service.ActivityService;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping("/test")
    public R createActive(@RequestBody Activity act) {
        Activity activity = Activity.newBuilder()
                .certCode("123")
                .description("123, desc")
                .createTime(new Date())
                .endTime(new Date())
                .sign("123")
                .lastModifyTime(new Date())
                .startTime(new Date())
                .theme("123 theme")
                .build();

        activityService.insertSelective(activity);

        return R.ok(activity.getId());
    }

}
