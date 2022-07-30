package com.example.diid.config;


import com.example.diid.config.props.MyConfigPropertis;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


// 自定义自动配置类（完成数据库分页的大小设置）
@Configuration
@EnableConfigurationProperties(MyConfigPropertis.class)
public class MyConfig {
}
