package com.natsucloud.sys.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.natsucloud.common.mybatis.controller.BaseController;
import com.natsucloud.sys.service.ISysUserService;
import com.natsucloud.sys.entity.SysUser;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
@RestController
@RequestMapping("/")
public class SysUserController extends BaseController<ISysUserService, SysUser> {

    @Autowired
    ISysUserService sysUserService;

    @RequestMapping("/demo")
    public String demo() throws Exception {
        SysUser sysUser = new SysUser();

        /*sysUser.setUsername("冷秋湖");
        sysUser.setPassword("123456");
        sysUser.setRemark("测试账号");

        sysUserService.add(sysUser);*/

        List<SysUser> userList = sysUserService.findAll();

        String result = JSON.toJSONString(userList);

        return result;
    }

}

