package com.kang.kangtemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 项目启动类
 * @author: liukang
 * @date: 2024/12/07 23:34:23
 */
@SpringBootApplication
@MapperScan("com.kang.kangtemplate.mapper")
public class KangTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(KangTemplateApplication.class, args);
    }
}
