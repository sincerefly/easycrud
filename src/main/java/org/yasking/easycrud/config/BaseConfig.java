package org.yasking.easycrud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// 使用 MapperScan批量注册 mapper文件
@Configuration
@MapperScan(basePackages = {"org.yasking.easycrud.mapper"})
public class BaseConfig {
}
