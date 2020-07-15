/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.mapp.bcd.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Schema(description = "合约调用参数")
@Data
public class WasmContractDto {

    public static String DONATE_SUBURI = "donate";

    public static String QUERY_DONOR_BY_HASH_SUBURI = "queryDonorByHash";

    public static String QUERY_DONOR_BY_USERID_SUBURI = "queryDonorByUserId";

    public static String DONAR_ACCOUNT = "donar";

    public static String DONATORY_ACCOUNT = "donatory";

    public static String MANAGER_ACCOUNT = "manager";

    public static String QUERY_ACCOUNT = "query";

    private Long userId;

    private String hashId;

    private String fileName;

    private String subUri;

    private String account;
}
