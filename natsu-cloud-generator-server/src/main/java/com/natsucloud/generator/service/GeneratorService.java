package com.natsucloud.generator.service;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;

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
        // 不配置则默认接口前缀=I
        if(!generateConfig.isServiceClassNameStartWithI()){
            gc.setServiceName("%sService");
        }
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
        mpg.setPackageInfo(pc);
//        //实体类父包
//        pc.setEntity("entity");
//        //controller父包
//        pc.setController("controller");
//        //mapper父包
//        pc.setMapper("mapper");
//        //xml父包
//        pc.setXml("resources.mapper");
//        pc.setServiceImpl("service.impl");
//        pc.setService("service");

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return generateConfig.getXmlPath() +"/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 配置模板
        TemplateConfig tmp = new TemplateConfig();
        // 默认Velocity模板引擎
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        //mpg.setTemplate(tmp);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);

        if(generateConfig.getTablePrefix().length>0) {
            if (generateConfig.getTablePrefix()[0] == "null") {
                // do nothing
            } else {
                strategy.setTablePrefix(generateConfig.getTablePrefix());
            }
        }

        strategy.setSuperEntityColumns("id");
        // mapper 父类
        //strategy.setSuperMapperClass("com.natsucloud.common.mybatis.base.mapper.SuperMapper");
        // 控制器父类
        strategy.setSuperControllerClass(("com.natsucloud.common.mybatis.controller.BaseController"));
        // 实体父类
        strategy.setSuperEntityClass("com.natsucloud.common.mybatis.entity.BaseEntity");
        // 接口父类
        strategy.setSuperServiceClass("com.natsucloud.common.mybatis.service.IBaseService");
        // 接口实现类父类
        strategy.setSuperServiceImplClass("com.natsucloud.common.mybatis.service.impl.BaseServiceImpl");
        // 需要生成的表
        strategy.setInclude(generateConfig.getIncludeTables());

        mpg.setStrategy(strategy);


        // 执行生成
        mpg.execute();

    }

}
