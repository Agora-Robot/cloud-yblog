package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.ArticleFallbackFeign;
import com.boot.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ArticleFallbackFeignImpl implements ArticleFallbackFeign {

    @Override
    public Map<String, Object> selectAllArticleByPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<Article> selectAllArticleOrderByDesc() {
        return null;
    }

    @Override
    public List<Article> selectArticleByRecommendPage(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Article selectArticleByArticleIdNoComment(long id) {
        return null;
    }

    @Override
    public List<Article> selectArticleByRecommend() {
        return null;
    }

    @Override
    public int selectArticleCount() {
        return 0;
    }

    @Override
    public List<Article> queryArticleByCategoryName(String categoryName) {
        return null;
    }


    @Override
    public Map<String, Object> selectAllArticleByCreated(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int queryArticleByTitleCount(String title) {
        return 0;
    }

    @Override
    public List<Article> queryArticleByTitle(int pageNum, int pageSize, String title) {
        return null;
    }
}
