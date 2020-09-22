package org.yasking.easycrud.data.service;

public interface TestService {

    // 获取MySQL版本号
    public String getVersion();

    // 获取PostgreSQL版本号
    public String getVersionFromPg();

}
