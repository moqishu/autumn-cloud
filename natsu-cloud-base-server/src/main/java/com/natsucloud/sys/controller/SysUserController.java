package com.natsucloud.sys.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.natsucloud.common.logback.LogHelper;
import com.natsucloud.common.logback.LoggerUtils;
import com.natsucloud.common.model.PageData;
import com.natsucloud.common.utils.JsonUtils;
import com.natsucloud.common.logback.LoggerBuilder;
import com.natsucloud.sys.entity.SysSqldemo;
import com.natsucloud.sys.service.ISysSqldemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.natsucloud.common.mybatis.controller.BaseController;
import com.natsucloud.sys.service.ISysUserService;
import com.natsucloud.sys.entity.SysUser;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    ISysSqldemoService sysSqldemoService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoggerBuilder loggerBuilder;

    @RequestMapping("/demo")
    public String demo() throws Exception {
        SysUser sysUser = new SysUser();
//        logger.info("logback 成功了1");
//        logger.error("logback 成功了2");
        logger.debug("logback 成功了3");

        LogHelper.debug("测试行号问题");
        LoggerUtils.error("sfsfsfsfsdfsd");
        LoggerUtils.debug("三生三世");
        LogHelper.debug("测测试案例");
        LogHelper.info("可是");
        LogHelper.error("可是s");

        /*sysUser.setUsername("冷秋湖");
        sysUser.setPassword("123456");
        sysUser.setRemark("测试账号");

        sysUserService.add(sysUser);*/

//        List<SysUser> userList = sysUserService.findAll();
//
//        String result = JSON.toJSONString(userList);
//
//        List<SysSqldemo> userList2 = sysSqldemoService.findAll();
//
//        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
//
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("currentPage",1);
//        map.put("pageSize",2);
//
//        PageData pageData =  sysSqldemoService.PageListMap(JsonUtils.toJSONDateFormat(map));
//
//        PageData pageData2 =  sysUserService.PageList(JSON.toJSONString(map));
//        String result2 = JsonUtils.toJSONDateFormat(pageData);
//        String result3 = JSON.toJSONString(pageData2);
//        String result4 = JSON.toJSONString(pageData);
//        Map<String,Object> map2 = new HashMap<String,Object>();
//        map2.put("data", LocalDate.now());
//        map2.put("sss", LocalDateTime.now());
//
//        String sss= JSON.toJSONString(map2);
        return "你们好";
    }

}

