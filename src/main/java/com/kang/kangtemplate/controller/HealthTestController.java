package com.kang.kangtemplate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 健康检测
 * @author: liukang
 * @date: 2024/12/08 00:09:52
 */
@RestController
@RequestMapping("/health")
public class HealthTestController {

    @RequestMapping("/test")
    public String test() {
        return "success";
    }

}
