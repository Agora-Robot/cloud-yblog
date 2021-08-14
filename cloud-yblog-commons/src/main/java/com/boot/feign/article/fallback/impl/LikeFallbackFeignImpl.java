package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.LikeFallbackFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LikeFallbackFeignImpl implements LikeFallbackFeign {
    @Override
    public String selectLikeExsit(String username, long articleid) {
        return null;
    }

    @Override
    public int selectLikeCount(long id) {
        return 0;
    }

}
