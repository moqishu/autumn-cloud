package com.natsucloud.openfeign.controller;

import com.natsucloud.openfeign.service.FeignDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignDemoController {

    @Autowired
    public FeignDemo feignDemo;

    @RequestMapping("/test")
    public String hello() {
        return feignDemo.hello();
    }

}
