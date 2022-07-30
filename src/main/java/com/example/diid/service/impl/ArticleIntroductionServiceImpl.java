package com.example.diid.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.diid.dao.ArticleInfoAndIntroDao;
import com.example.diid.dao.ArticleIntroductionDao;
import com.example.diid.entity.ArticleInfoAndIntro;
import com.example.diid.entity.ArticleIntroduction;
import com.example.diid.service.ArticleIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ArticleIntroductionService接口的实现类
@Service
@Transactional
public class ArticleIntroductionServiceImpl implements ArticleIntroductionService {

    @Autowired
    private ArticleIntroductionDao dao;

    @Autowired
    private ArticleInfoAndIntroDao infoAndIntroDao;

    @Override
    public Map selectByPage(int current, int size) {// 一个是自己配置的大小，一个是当前页。
        HashMap<String, Object> map = new HashMap<>();
        Page<ArticleIntroduction> selectPage = dao.selectPage(
                new Page<ArticleIntroduction>(current, size),
                new QueryWrapper<ArticleIntroduction>().orderByDesc("id")
        );
        List<ArticleIntroduction> lists = new ArrayList<>();
        selectPage.getRecords().forEach((e) -> {
            ArticleInfoAndIntro infoAndIntro = infoAndIntroDao.selectOne(
                    new QueryWrapper<ArticleInfoAndIntro>()
                            .eq("intro_id", e.getId()));
            if (null != infoAndIntro) {
                e.setTags(e.getTags() + "|" + infoAndIntro.getInfoId());
            } else {
                e.setTags(e.getTags() + "|" + "#");
            }

            lists.add(e);
        });
        map.put("data", lists);
        map.put("current", selectPage.getCurrent());
        map.put("size", selectPage.getSize());
        map.put("pages", selectPage.getPages());
        map.put("totals", selectPage.getTotal());
        return map;
    }
}
