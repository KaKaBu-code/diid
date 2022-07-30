package com.example.diid.service;

import java.util.Map;

public interface ArticleIntroductionService {
    Map selectByPage(int current, int size);
}
