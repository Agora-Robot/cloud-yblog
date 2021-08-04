package com.boot.feign.article.impl;

import com.boot.feign.article.SearchFeign;
import com.boot.pojo.Article;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class SearchFeignImpl implements SearchFeign {


    @Override
    public SearchHit[] searchArticleGetHits(String searchText) throws IOException {
        log.error("SearchFeignImpl---searchArticleGetHits--fallback");
        return null;
    }

    @Override
    public List<Article> getArticleListByHits(SearchHit[] searchHits) {
        log.error("SearchFeignImpl---getArticleListByHits--fallback");
        return null;
    }
}
