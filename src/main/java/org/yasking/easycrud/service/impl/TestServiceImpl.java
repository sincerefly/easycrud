package org.yasking.easycrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yasking.easycrud.mapper.TestMapper;
import org.yasking.easycrud.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    public String getVersion() {
        return testMapper.getVersion();
    }

    public String getVersionFromXML() {
        return testMapper.getVersionFromXML();
    }
}
