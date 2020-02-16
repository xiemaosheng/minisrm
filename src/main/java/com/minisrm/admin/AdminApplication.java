package com.minisrm.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * 产品管理平台 后台项目启动类
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.minisrm.admin.mapper")
@ComponentScan(basePackages = {"com.minisrm.admin"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
