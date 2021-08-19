package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.LinkFallbackFeign;
import com.boot.pojo.Link;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class LinkFallbackFeignImpl implements LinkFallbackFeign {
    @Override
    public List<Link> selectAllLink() {
        return null;
    }

    @Override
    public int linkCount() {
        return 0;
    }

    @Override
    public List<Link> selectLinkByTitle(String title) {
        return null;
    }

    @Override
    public int selectCountByTitle(String title) {
        return 0;
    }
}
