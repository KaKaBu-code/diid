package com.example.diid.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


// 对应MyConfig的配置类
// 配置前缀为 "sylvie"
@ConfigurationProperties(prefix = "sylvie")
@Data
public class MyConfigPropertis {
    public String name;

    // 配置分页大小 
    // sylvie.pagesize = ?
    public Integer pagesize;
}
