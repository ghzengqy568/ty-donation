package com.baidu.mapp.bcd.service.impl;

import com.baidu.mapp.bcd.dao.AdminMapper;
import com.baidu.mapp.bcd.dao.base.BaseMapper;
import com.baidu.mapp.bcd.domain.Admin;
import com.baidu.mapp.bcd.domain.AdminExample;
import com.baidu.mapp.bcd.service.AdminService;
import com.baidu.mapp.bcd.service.base.GenericServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl extends GenericServiceImpl<Admin, Long, AdminExample> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public BaseMapper<Admin, Long, AdminExample> getMapper() {
        return adminMapper;
    }

    @Override
    public AdminExample newExample() {
        return AdminExample.newBuilder().build();
    }

    @Override
    public AdminExample newIdInExample(List<Long> ids) {
        return AdminExample.newBuilder().build().createCriteria().andIdIn(ids).toExample();
    }
}