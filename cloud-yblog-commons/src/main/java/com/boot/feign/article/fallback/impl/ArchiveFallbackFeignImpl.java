package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.ArchiveFallbackFeign;
import com.boot.pojo.Archive;
import com.boot.pojo.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArchiveFallbackFeignImpl implements ArchiveFallbackFeign {
    @Override
    public List<Archive> selectAllArchiveGroup() {
        return null;
    }

    @Override
    public List<Article> selectArticleByarchiveTime(String date) {
        return null;
    }
}
