/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

import com.baidu.mapp.bcd.domain.Certificate;

public interface ChainService {

    /**
     * @param userId,   流水+详情 -> 捐赠人ID，
     *                  领取记录 -> 受捐人ID
     *                  活动，计划，拨款 —> 操作人ID
     * @param tableName
     * @param id
     * @param sign
     *
     * @return
     */

    String writeChain(Long userId, String tableName, Long id, String sign, String content);

    /**
     * 通过证书号查询本地DB中证书记录
     * @param certCode 被查询的证书号
     * @return 本地DB中存储的证书记录
     */
    Certificate queryCert(String certCode);

    /**
     * 通过证书号查询链上存储的内容
     * @param certCode 被查询的链上证书号
     * @return 返回对应的链上内容, 即sign
     */
    String readChain(String certCode);
}
