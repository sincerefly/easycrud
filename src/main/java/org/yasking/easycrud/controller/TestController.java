package org.yasking.easycrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> helloWorld() {
        HashMap<String, String> data = new HashMap<>();
        data.put("say", "hello world!");
        return data;
    }
}
