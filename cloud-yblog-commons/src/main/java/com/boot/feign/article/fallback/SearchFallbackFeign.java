package com.boot.feign.article.fallback;


import com.boot.feign.article.fallback.impl.SearchFallbackFeignImpl;
import com.boot.pojo.Article;
import org.elasticsearch.search.SearchHit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-search",fallback = SearchFallbackFeignImpl.class)
public interface SearchFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/search/searchArticleGetHits")
    public SearchHit[] searchArticleGetHits(@RequestParam("searchText") String searchText) throws IOException;

    @ResponseBody
    @GetMapping(path = "/feign/search/getArticleListByHits")
    public List<Article> getArticleListByHits(@RequestBody SearchHit[] searchHits);


}
