package com.baidu.mapp.bcd.service.base;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baidu.mapp.bcd.dao.base.BaseSQL;
import com.baidu.mapp.bcd.dao.base.CommonMapper;
import com.baidu.mapp.bcd.dao.base.SQLParam;

public interface CommonService {
    List<Map<String, Object>> selectListMap(BaseSQL baseSql, SQLParam sqlParam);

    Map<String, Object> selectOneMap(BaseSQL baseSql, SQLParam sqlParam);

    String selectOneString(BaseSQL baseSql, SQLParam sqlParam);

    Long selectOneLong(BaseSQL baseSql, SQLParam sqlParam);

    Integer selectOneInteger(BaseSQL baseSql, SQLParam sqlParam);

    Byte selectOneByte(BaseSQL baseSql, SQLParam sqlParam);

    Date selectOneDate(BaseSQL baseSql, SQLParam sqlParam);

    CommonMapper getCommonMapper();
}
