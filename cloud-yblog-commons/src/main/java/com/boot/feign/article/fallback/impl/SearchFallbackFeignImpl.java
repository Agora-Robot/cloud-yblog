package com.boot.feign.article.fallback.impl;

import com.boot.feign.article.fallback.SearchFallbackFeign;
import com.boot.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class SearchFallbackFeignImpl implements SearchFallbackFeign {
    @Override
    public SearchHit[] searchArticleGetHits(String searchText) throws IOException {
        return null;
    }

    @Override
    public List<Article> getArticleListByHits(SearchHit[] searchHits) {
        return null;
    }
}
