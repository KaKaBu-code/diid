package com.example.diid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// article_info_intro表对应的实体类
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("article_info_intro")
public class ArticleInfoAndIntro {
    @TableId(type = IdType.AUTO, value = "id")
    private Integer id;

    @TableField("info_id")
    private String infoId;

    @TableField("intro_id")
    private String introId;
}
