package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.feign.article.ArticleFeign;
import com.boot.pojo.Article;
import com.boot.service.ElasticSearchService;
import io.swagger.annotations.Api;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/feign/search")
@Api("搜索Api")
public class SearchController {

  @Autowired private ElasticSearchService elasticSearchService;

  @Autowired
  @Qualifier("restHighLevelClient")
  private RestHighLevelClient client;

  @Autowired
  @Lazy
  private ArticleFeign articleFeign;

  private final String INDEX="blog_article"; //索引名字必须全部是小写

  /**
   * ************第一次使用本项目要把下面的方法解除注释，运行一遍
   * 当搜索服务一启动，立刻就会加载数据库系统的文章并放到elasticSearch中（预热）。
   */
//  @PostConstruct
//  public void loadArticleToElaticSearch() throws IOException {
//
//
//// ===============================================================================================
//
//    //先查询出这个索引中所有文档的id，再进行批量删除（提高效率）
//    SearchRequest searchRequest = new SearchRequest(INDEX);
//    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//    searchSourceBuilder.size(9999); //设置查询展示的数量，默认是10,最大是9999
//    searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//    searchRequest.source(searchSourceBuilder);
//    SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
//
//    SearchHits hits = search.getHits();
//
//    SearchHit[] hits1 = hits.getHits();
//
//
//    BulkRequest bulkRequest = new BulkRequest(); //封装批量操作
//
//    for (SearchHit searchHit : hits1) {
//      DeleteRequest deleteRequest = new DeleteRequest(INDEX);
//      deleteRequest.id(searchHit.getId());
//      bulkRequest.add(deleteRequest);  //封装删除请求
//    }
//    client.bulk(bulkRequest,RequestOptions.DEFAULT); //批量执行删除
//
//// ============================================================================================
//
//    List<Article> articles = articleFeign.selectAllArticleOrderByDesc();
//    BulkRequest bulkRequest1 = new BulkRequest(); //封装批量添加文档请求
//
//    for (int i = 0; i < articles.size(); i++) {
//      IndexRequest indexRequest = new IndexRequest(); //文档
//      indexRequest.index(INDEX);//指定索引
//      indexRequest.id(i+""); //文档id
//      indexRequest.source(JSON.toJSONString(articles.get(i)), XContentType.JSON);
//      bulkRequest1.add(indexRequest);
//    }
//    client.bulk(bulkRequest1, RequestOptions.DEFAULT);
//
//
//  }


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
