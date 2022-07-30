package com.example.diid.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


// 控制页面跳转的控制器
@Controller
@RequestMapping("/")
public class ViewController {

    // 首页跳转
    @RequestMapping("/index")
    public String indexView() {
        return "index";
    }

    // 具体页面跳转
    @RequestMapping("/page/{id}")
    public String  pageIndex(@PathVariable("id") Integer id) {
        System.out.println("当前页: " + id);
        return "article";
    }
}
