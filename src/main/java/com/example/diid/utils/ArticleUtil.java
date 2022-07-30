package com.example.diid.utils;

import com.example.diid.entity.Article;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


// 读取.txt文章封装到Article实体类中
public class ArticleUtil {
    public static Article readArticleFromtxt(String path) throws IOException {
        Article article = new Article();
        File file = new File(path);
        if (!file.exists()) {
            article.setArticle("文件不存在" + "<br>");
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp = "";
            int flag = 0;
            while ((tmp = reader.readLine()) != null) {// 每次读取一行。
                if (tmp.startsWith("-image:")) {
                    flag = 1;
//                    continue;
                } else if (tmp.startsWith("-article:")) {
                    flag = 2;
//                    continue;
                }

                if (1 == flag) {
                    if (!tmp.trim().equals("")) {
                        article.addImageItem(tmp.trim().substring(7));
                    }
                } else if (2 == flag) {
                    article.appendArticle(tmp.substring(9) + "<br>");
                }
            }
            reader.close();
        }
//        System.out.println(article);
        return article;
    }
}
