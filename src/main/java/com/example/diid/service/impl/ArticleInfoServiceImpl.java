package com.example.diid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.diid.dao.ArticleInfoAndIntroDao;
import com.example.diid.dao.ArticleInfoDao;
import com.example.diid.dao.ArticleIntroductionDao;
import com.example.diid.entity.ArticleInfo;
import com.example.diid.entity.ArticleInfoAndIntro;
import com.example.diid.entity.ArticleIntroduction;
import com.example.diid.service.ArticleInfoService;
import com.example.diid.utils.ArticleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// ArticleInfoService接口的实现类
@Service
@Transactional
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoDao infoDao;

    @Autowired
    private
    ArticleIntroductionDao introDao;

    @Autowired
    private ArticleInfoAndIntroDao infoAndIntroDao;

    @Override
    public Map getArticleById(Integer id) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        ArticleInfo info = infoDao.selectById(id);
        if (null != info) {
            if (null != info.getApath()) {
                map.put("article", ArticleUtil.readArticleFromtxt(info.getApath()));
            }
            ArticleInfoAndIntro infoAndIntro = infoAndIntroDao.selectOne(new QueryWrapper<ArticleInfoAndIntro>().eq("info_id", info.getId()));

            if (null != infoAndIntro.getIntroId()) {
                ArticleIntroduction intro = introDao.selectById(infoAndIntro.getInfoId());
                if (null != intro) {
                    map.put("intro", intro);
                }
            }

        }
        return map;
    }
}
