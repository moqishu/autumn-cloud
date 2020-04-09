package com.natsucloud.generator.service;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;

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
    }

}
