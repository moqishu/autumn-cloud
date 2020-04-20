package com.natsucloud.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "natsucloud-base-server")
public interface FeignDemo {

    @RequestMapping("/demo")
    String hello();


}
