package org.yasking.easycrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.yasking.easycrud.service.TestService;

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

    // 使用 @Select注解方式从数据库查询数据
    @RequestMapping(value = "/getVersion", method = RequestMethod.GET)
    public String getVersion() {
        String version = testService.getVersion();
        return version;
    }

    // 使用 XML中的 SQL来查询数据
    @RequestMapping(value = "/getVersionFromXML", method = RequestMethod.GET)
    public String getVersionFromXML() {
        String version = testService.getVersionFromXML();
        return version;
    }
}
