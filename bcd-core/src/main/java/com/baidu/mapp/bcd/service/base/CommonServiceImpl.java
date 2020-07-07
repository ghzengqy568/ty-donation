package com.baidu.mapp.bcd.service.base;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.mapp.bcd.dao.base.BaseSQL;
import com.baidu.mapp.bcd.dao.base.CommonMapper;
import com.baidu.mapp.bcd.dao.base.SQLParam;

public abstract class CommonServiceImpl implements CommonService {

    @Autowired
    protected CommonMapper commonMapper;

    public List<Map<String, Object>> selectListMap(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectListMap(baseSql, sqlParam);
    }

    public Map<String, Object> selectOneMap(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneMap(baseSql, sqlParam);
    }

    public String selectOneString(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneString(baseSql, sqlParam);
    }

    public Long selectOneLong(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneLong(baseSql, sqlParam);
    }

    public Integer selectOneInteger(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneInteger(baseSql, sqlParam);
    }

    public Byte selectOneByte(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneByte(baseSql, sqlParam);
    }

    public Date selectOneDate(BaseSQL baseSql, SQLParam sqlParam) {
        return commonMapper.selectOneDate(baseSql, sqlParam);
    }

    public CommonMapper getCommonMapper() {
        return commonMapper;
    }
}
