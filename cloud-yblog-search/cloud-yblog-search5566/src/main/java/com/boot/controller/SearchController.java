package com.boot.controller;

import com.boot.pojo.Article;
import com.boot.service.ElasticSearchService;
import io.swagger.annotations.Api;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/feign/search")
@Api("搜索Api")
public class SearchController {

  @Autowired private ElasticSearchService elasticSearchService;

  @ResponseBody
  @GetMapping(path = "/searchArticleGetHits")
  public SearchHit[] searchArticleGetHits(@RequestParam("searchText") String searchText)
      throws IOException {

    SearchHit[] searchHits = elasticSearchService.searchArticleGetHits(searchText);


    return searchHits;
  }

  @ResponseBody
  @GetMapping(path = "/getArticleListByHits")
  public List<Article> getArticleListByHits(@RequestBody SearchHit[] searchHits) {

    List<Article> articleListByHits = elasticSearchService.getArticleListByHits(searchHits);
    return articleListByHits;
  }
}
