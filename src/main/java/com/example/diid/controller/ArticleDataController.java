package com.example.diid.controller;

import com.example.diid.config.props.MyConfigPropertis;
import com.example.diid.service.ArticleInfoService;
import com.example.diid.service.ArticleIntroductionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleDataController {
    @Autowired
    private MyConfigPropertis props;
    @Autowired
    private ArticleIntroductionService service;

    @Autowired
    private ArticleInfoService infoService;
    // 首页数据请求，current代表当前请求也
    @RequestMapping("/intro")
    @ResponseBody
    public Map articleIntro(@Param("current") Integer current) {
        System.out.println("select: current=" + current + ":" + "size=" + props.getPagesize());
        return service.selectByPage(current, props.getPagesize());
    }
    // 具体页面数据请求，id代表当前请求的具体页面
    @RequestMapping("/info/{id}")
    @ResponseBody
    public Map articleInfo(@PathVariable("id") Integer id) {
        Map map = null;
        try {
            map = infoService.getArticleById(id);
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取文章失败: " + id);
        }
        return  map;
    }
}
