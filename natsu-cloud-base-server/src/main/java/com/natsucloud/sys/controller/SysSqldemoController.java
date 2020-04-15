package com.natsucloud.sys.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.natsucloud.common.mybatis.controller.BaseController;
import com.natsucloud.sys.service.ISysSqldemoService;
import com.natsucloud.sys.entity.SysSqldemo;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author moqishu
 * @since 2020-04-15
 */
@Controller
@RequestMapping("/sys/sysSqldemo")
public class SysSqldemoController extends BaseController<ISysSqldemoService, SysSqldemo> {

}

