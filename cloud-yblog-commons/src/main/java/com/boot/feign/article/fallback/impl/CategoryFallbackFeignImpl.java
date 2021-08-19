package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.CategoryFallbackFeign;
import com.boot.pojo.Article;
import com.boot.pojo.Category;
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
    public Category selectCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public int selectCountByName(String categoryName) {
        return 0;
    }

    @Override
    public List<Category> selectCategories(int page, int limit) {
        return null;
    }

    @Override
    public int selectCategoryCount() {
        return 0;
    }

    @Override
    public List<Category> selectCategories_echarts() {
        return null;
    }
}
