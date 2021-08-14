package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.CategoryFallbackFeign;
import com.boot.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CategoryFallbackFeignImpl implements CategoryFallbackFeign {
    @Override
    public List<String> selectCategoryName() {
        return null;
    }

    @Override
    public List<Article> queryArticleByCategoryName(String categoryName) {
        return null;
    }
}
