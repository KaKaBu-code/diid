package com.example.diid.service;

import java.io.IOException;
import java.util.Map;

// 对应article_info表的service操作
public interface ArticleInfoService {
    Map getArticleById(Integer id) throws IOException;
}
