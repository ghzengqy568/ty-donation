/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.service;

/**
 * 数据上链与链上数据查询接口
 */
public interface ChainService {

    /**
     * 数据上链
     *
     * @param userId,   流水+详情 -> 捐赠人ID
     *                  领取记录 -> 受捐人ID
     *                  活动，计划，拨款 —> 操作人ID
     * @param domain 数据域
     * @param id 数据标识
     * @param sign 上链数据签名
     * @param content 上链原始数据
     * @return 链上存证地址
     */
    String writeChain(Long userId, String domain, Long id, String sign, String content);

    /**
     * 通过存证地址查询链上数据
     * @param address 链上存证地址
     * @return 返回对应的链上数据
     */
    String readChain(String address);

}
