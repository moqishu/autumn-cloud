package com.natsucloud.generator.service;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import sun.security.krb5.internal.crypto.Des;

/**
 * 代码生成器
 */
public class GeneratorService {

    public static void execute(GenerateConfig generateConfig){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(generateConfig.getOutputDir());
        gc.setFileOverride(true);
        gc.setAuthor(generateConfig.getAuthor());
        gc.setOpen(false);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据库配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(generateConfig.getDbType());
        dsc.setDriverName(generateConfig.getJdbcDriver());
        dsc.setUrl(generateConfig.getJdbcUrl());
        dsc.setUsername(generateConfig.getJdbcUserName());
        dsc.setPassword(generateConfig.getJdbcPassword());
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(generateConfig.getModuleName());
        pc.setParent(generateConfig.getParentPackage());
        //实体类父包
        pc.setEntity("server.entity");
        //controller父包
        pc.setController("server.controller");
        //mapper父包
        pc.setMapper("server.mapper");
        //xml父包
        pc.setXml("server.xml");
        pc.setServiceImpl("server.service.impl");
        pc.setService("server.service");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig tmp = new TemplateConfig();
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.setTemplate(tmp);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setTablePrefix(generateConfig.getTablePrefix());
        strategy.setSuperEntityColumns("id");
        // mapper 父类
        //strategy.setSuperMapperClass("com.natsucloud.common.mybatis.base.mapper.SuperMapper");
        // 实体父类
        strategy.setSuperEntityClass("com.natsucloud.common.mybatis.entity.BaseEntity");
        // 接口父类
        strategy.setSuperServiceClass("com.natsucloud.common.mybatis.service.IBaseService");
        // 接口实现类父类
        strategy.setSuperServiceImplClass("com.opencloud.common.mybatis.service.impl.BaseServiceImpl");
        // 需要生成的表
        strategy.setInclude(generateConfig.getIncludeTables());
        mpg.setStrategy(strategy);


        // 执行生成
        mpg.execute();

    }

}
