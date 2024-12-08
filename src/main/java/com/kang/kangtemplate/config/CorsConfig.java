package com.kang.kangtemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 跨域处理配置类
 * @author: liukang
 * @date: 2024/12/08 00:03:28
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                         // 允许所有路径进行跨域请求
                .allowedOriginPatterns("/api")                             // 允许/api开头的请求访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的 HTTP 请求类型
                .allowedHeaders("*")                                       // 允许的请求头
                .allowCredentials(true)                                    // 是否允许发送 Cookie
                .maxAge(3600);                                             // 预检请求的缓存时间，单位为秒
    }
}