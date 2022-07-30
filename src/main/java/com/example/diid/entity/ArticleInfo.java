package com.example.diid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// article_info表对应的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article_info")
public class ArticleInfo implements Serializable {
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;

    @TableField("apath")
    private String apath;
}
