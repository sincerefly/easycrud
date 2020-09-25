package org.yasking.easycrud.data.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

// 使用 MapperScan批量注册 mapper文件
@Configuration
@EnableScheduling
@MapperScan(basePackages = {"org.yasking.easycrud.data.mapper"})
public class BaseConfig {
}
