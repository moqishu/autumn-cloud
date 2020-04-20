package com.natsucloud.openfeign.controller;

import com.natsucloud.openfeign.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    public DemoService demoService;

    @RequestMapping("/test")
    public String test(){
        return demoService.demo();
    }
}
