package com.baidu.mapp.bcd.dao;

import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.DonateDetail;
import com.baidu.mapp.bcd.domain.DonateDetailExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DonateDetailMapper extends BaseMapper<DonateDetail, Long, DonateDetailExample> {

    Long sumMoneyBalanceByExample(DonateDetailExample example);

}
