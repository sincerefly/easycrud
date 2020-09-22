package org.yasking.easycrud.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yasking.easycrud.data.service.TestService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, String> helloWorld() {
        HashMap<String, String> data = new HashMap<>();
        data.put("say", "hello world!");
        return data;
    }

    // MySQL版本号
    @RequestMapping(value = "/myVersion", method = RequestMethod.GET)
    public String getVersion() {
        String version = testService.getVersion();
        return version;
    }

    // PostgreSQL版本号（使用 @Select注解方式）
    @RequestMapping(value = "/pgVersion", method = RequestMethod.GET)
    public String getVersionFromPg() {
        String version = testService.getVersionFromPg();
        return version;
    }
}
