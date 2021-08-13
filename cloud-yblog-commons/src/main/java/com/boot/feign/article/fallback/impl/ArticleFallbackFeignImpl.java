package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.ArticleFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ArticleFallbackFeignImpl implements ArticleFallbackFeign {


    @Override
    public String selectLikeExsit(String username, long articleid) {
        
        return null;
    }
}
