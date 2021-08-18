package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.ArticleFallbackFeignImpl;
import com.boot.pojo.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author 游政杰
 * 2021/8/13
 */

//***实现一部分接口需要自定义fallback一部分接口不需要自定义fallback，起到一个分离的作用
@Component
@FeignClient(value = "cloud-yblog-article",fallback = ArticleFallbackFeignImpl.class)
public interface ArticleFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/article/selectAllArticle")
    public Map<String,Object> selectAllArticleByPage(@RequestParam("pageNum") int pageNum,
                                                     @RequestParam("pageSize") int pageSize);

    @ResponseBody
    @GetMapping(path = "/feign/article/selectAllArticleOrderByDesc")
    public List<Article> selectAllArticleOrderByDesc();


    @ResponseBody
    @GetMapping(path = "/feign/article/selectArticleByRecommendPage")
    public List<Article> selectArticleByRecommendPage(@RequestParam("pageNum") int pageNum,
                                                      @RequestParam("pageSize") int pageSize);


    @ResponseBody
    @GetMapping(path = "/feign/article/selectArticleByArticleIdNoComment")
    public Article selectArticleByArticleIdNoComment(@RequestParam("id") long id);


    @ResponseBody
    @GetMapping(path = "/feign/article/selectArticleByRecommend")
    public List<Article> selectArticleByRecommend();

    @ResponseBody
    @GetMapping(path = "/feign/article/selectArticleCount")
    public int selectArticleCount();


    @ResponseBody
    @RequestMapping(path = "/feign/article/queryArticleByCategoryName")
    public List<Article> queryArticleByCategoryName(@RequestParam("categoryName")String categoryName);


    @ResponseBody
    @GetMapping(path = "/feign/article/selectAllArticleByCreated")
    public Map<String,Object> selectAllArticleByCreated(@RequestParam("pageNum") int pageNum,
                                                        @RequestParam("pageSize") int pageSize);

    @ResponseBody
    @GetMapping(path = "/feign/article/queryArticleByTitleCount")
    public int queryArticleByTitleCount(@RequestParam("title") String title);


    @ResponseBody
    @GetMapping(path = "/feign/article/queryArticleByTitle")
    public List<Article> queryArticleByTitle(@RequestParam("pageNum") int pageNum,
                                             @RequestParam("pageSize") int pageSize,
                                             @RequestParam("title") String title);


}
