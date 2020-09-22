package org.yasking.easycrud.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yasking.easycrud.data.config.TargetDataSource;
import org.yasking.easycrud.data.mapper.PgMapper;
import org.yasking.easycrud.data.mapper.MysqlMapper;
import org.yasking.easycrud.data.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    MysqlMapper mysqlMapper;

    @Autowired
    PgMapper pgMapper;

    // MySQL数据源（默认）
    public String getVersion() {
        return mysqlMapper.getVersion();
    }

    // PostgreSQL数据源
    @TargetDataSource(dataSource = "pg")
    public String getVersionFromPg() {
        return pgMapper.getVersion();
    }

}
