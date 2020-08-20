package com.natsucloud.sys.controller;

import com.alibaba.fastjson.JSON;
import com.natsucloud.common.logback.LogHelper;
import com.natsucloud.common.multidb.DataSource;
import com.natsucloud.common.multidb.DataSourceType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @DataSource(DataSourceType.MASTER)
    @RequestMapping("/demo")
    public String demo() throws Exception {
        SysUser sysUser = new SysUser();
        List<SysUser> userList = sysUserService.findAll();

        LogHelper.info("一切尽在不言中");


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

        sysUserService.get();

        String result= JSON.toJSONString(userList);
        return result;
    }

    @DataSource(DataSourceType.SLAVE)
    @RequestMapping("/hello")
    @Cacheable(value = "hello",key = "'sss'")
    public String hello() throws Exception {
        SysUser sysUser = new SysUser();
        List<SysUser> userList = sysUserService.findAll();

        String result= JSON.toJSONString(userList);
        return result;
    }

    @DataSource(DataSourceType.SLAVE)
    @RequestMapping("remove")
    @CacheEvict(value = "hello",key = "'sss'")
    public String removeCache(){
        return "清理缓存";
    }

    @RequestMapping("update")
    @CachePut(value = "hello",key = "")
    public String updateCache() throws Exception {
        List<SysUser> userList = sysUserService.findAll();
        String result= JSON.toJSONString(userList);
        return result;
    }

}

