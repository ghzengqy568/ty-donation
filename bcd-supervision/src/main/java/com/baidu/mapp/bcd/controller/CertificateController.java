/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.mapp.bcd.common.utils.digest.Digest;
import com.baidu.mapp.bcd.domain.base.R;
import com.baidu.mapp.bcd.service.ChainService;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "证书查询", name = "CertificateController")
@RestController
@RequestMapping("/cert")
public class CertificateController {

    @Autowired
    ChainService chainService;

    @Autowired
    Digest digest;

    @GetMapping("fetch/{certCode}")
    public R<String> queryByCertCode(@PathVariable("certCode") String certCode) throws Exception {
        String res = chainService.readChain(certCode);
        if (StringUtils.isNotBlank(res)) {
            String[] split = res.split("\t");
            String content = split[2];

            String[] split1 = content.split(":");
            return R.ok(digest.decryptDes(split1[1]));
        }
        return R.ok("");
    }
}
