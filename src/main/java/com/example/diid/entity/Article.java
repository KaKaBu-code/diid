package com.example.diid.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


// 解析文章封装的实体类
@Data
@AllArgsConstructor
public class Article {
    private List<String> images;
    private String article;

    public Article() {
        this.images = new ArrayList<>();
        this.article = "";
    }

    public void addImageItem(String imgPath) {
        this.images.add(imgPath);
    }
    public void appendArticle(String text) {
        this.article += text;
    }
}
