package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.constant.ThemeConstant;
import com.boot.feign.article.*;
import com.boot.feign.article.fallback.*;
import com.boot.pojo.Article;
import com.boot.pojo.Link;
import com.boot.pojo.Tag;
import com.boot.service.ElasticSearchService;
import com.boot.utils.Commons;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/** @author 游政杰 2021/5/22 15:54 */
@Controller
@Api("搜索 web api")
@RequestMapping(path = "/web")
public class SearchController {

  @Autowired private ArticleFallbackFeign articleFallbackFeign;

  @Autowired private RedisTemplate redisTemplate;

  @Autowired private LinkFallbackFeign linkFallbackFeign;

  @Autowired private SearchFallbackFeign searchFallbackFeign;

  @Autowired private ElasticSearchService elasticSearchService; // 暂时把搜索业务放在web模块，待问题解决后在分离出来

  @Autowired private LikeFallbackFeign likeFallbackFeign;

  @Autowired private TagFallbackFeign tagFallbackFeign;

  // 前10排行
  private static final List<Article> ArticleOrder_10(List<Article> articleList) {
    List<Article> list = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      list.add(articleList.get(i));
    }
    return list;
  }

  /** ************这里有bug，不能通过feign和resttemplate去搜索微服务获取SearchHit[]...................... */
  //  @ResponseBody
  //  @RequestMapping(path = "/test1")
  //  public SearchHit[] test(@RequestParam(value = "searchText", required = false) String
  // searchText)
  //      throws IOException {
  //
  //        SearchHit[] searchHits = searchFeign.searchArticleGetHits(searchText);
  //        if (searchHits == null) {
  //          System.out.println(0);
  //        }else {
  //          System.out.println(searchHits.length);
  //        }
  //
  //    return searchHits;
  //  }

  // 搜索，到时要使用es进行搜索功能增强
  @RequestMapping(path = "/search/{page}")
  public ModelAndView searchArticle(
      @PathVariable("page") int page,
      @RequestParam(value = "searchText", required = false) String searchText)
      throws IOException {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("articleFallbackFeign", articleFallbackFeign);
    modelAndView.addObject("likeFallbackFeign", likeFallbackFeign);
    // 跳转不同页面主题判断
    if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { // calm主题
      modelAndView.setViewName("client/index2"); // 跳转页面
      modelAndView.addObject("indexAc", "active");
      List<Tag> tags = tagFallbackFeign.selectTagsByLimit8();
      modelAndView.addObject("tags", tags);

    } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { // 默认主题
      modelAndView.setViewName("client/index"); // 跳转页面
    }

    // 搜索内容为空代表搜素全部
    if (searchText == null || searchText.equals("")) {
      Map<String, Object> map = articleFallbackFeign.selectAllArticleByPage(1, 5);
      String s2 = (String) map.get("pageInfo");

      // ******这里有坑，一定要用这种方式才可以转换集合，不然会出现类型转换异常，不能用JSONObject去转换
      List<Article> articles = JSON.parseArray((String) map.get("articles"), Article.class);

      PageInfo pageInfo = JSONObject.parseObject(s2, PageInfo.class);

      modelAndView.addObject("articles", articles);
      modelAndView.addObject("pageInfo", pageInfo);
    } else {
      // es搜索
      SearchHit[] searchHits = elasticSearchService.searchArticleGetHits(searchText);
      List<Article> articles = elasticSearchService.getArticleListByHits(searchHits);


      PageInfo pageInfo = new PageInfo(articles);

      modelAndView.addObject("articles", articles);
      modelAndView.addObject("pageInfo", pageInfo);
    }

    List<Article> as = (List<Article>) redisTemplate.opsForValue().get("articleOrders10");
    if (as == null) {
      List<Article> articleOrders = ArticleOrder_10(articleFallbackFeign.selectAllArticleOrderByDesc());
      redisTemplate.opsForValue().set("articleOrders10", articleOrders, 60 * 1, TimeUnit.SECONDS);
      modelAndView.addObject("articleOrders", articleOrders);
    } else {
      modelAndView.addObject("articleOrders", as);
    }
    modelAndView.addObject("commons", Commons.getInstance());

    // 友链
    List<Link> links = linkFallbackFeign.selectAllLink();
    modelAndView.addObject("links", links);
    return modelAndView;
  }
}
