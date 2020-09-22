package org.yasking.easycrud.data.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    // 如果直接使用druid包则需要自己创建数据源并应用以便附加配置生效
    // 使用druid-spring-boot-starter后无需此处配置

    // 创建自己的Druid数据源并绑定配置内的额外配置
    // @ConfigurationProperties(prefix = "spring.datasource")
    // @Bean
    // public DataSource druid() {
    //     return new DruidDataSource();
    // }
}
