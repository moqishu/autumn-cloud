package com.natsucloud.ktpark.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.natsucloud.common.mybatis.controller.BaseController;
import com.natsucloud.ktpark.service.ICarcomeService;
import com.natsucloud.ktpark.entity.Carcome;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author moqishu
 * @since 2020-04-14
 */
@RestController
@RequestMapping("/ktpark/carcome")
public class CarcomeController extends BaseController<ICarcomeService, Carcome> {

    @Autowired
    private ICarcomeService carcomeService;

    @RequestMapping("/demo")
    public String demo() throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("carPlateNum","闽A009428");
        List<Carcome> result = carcomeService.findByMap(map);
        QueryWrapper<Carcome> queryWrapper = new QueryWrapper<>();
        // lt为小于的意思
        queryWrapper.like("carPlateNum", "闽A00942");
        List<Carcome> users = carcomeService.findByQuery(queryWrapper);

        return "测试页面";
    }

}

