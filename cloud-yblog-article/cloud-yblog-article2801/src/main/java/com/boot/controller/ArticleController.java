package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.constant.Constant;
import com.boot.data.CommonResult;
import com.boot.pojo.Article;
import com.boot.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 游政杰
 */
@Controller
@RequestMapping(path = "/feign/article")
@Api("文章Api")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;



    @ResponseBody
    @GetMapping(path = "/selectAllArticle")
    public Map<String,Object> selectAllArticleByPage(@RequestParam("pageNum") int pageNum,
                                                    @RequestParam("pageSize") int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.selectAllArticle();

        //这个pageInfo只能写在这个调用sql语句的service方法下面才有用
        PageInfo pageInfo = new PageInfo(articles);

        Map<String,Object> map = new HashMap<>();

        String s1 = JSON.toJSONString(articles);
        String s2 = JSON.toJSONString(pageInfo);

        map.put("articles",s1);
        map.put("pageInfo",s2);

        return map;
    }

    @ResponseBody
    @GetMapping(path = "/selectLikeCount")
    public int selectLikeCount(@RequestParam("id") long id){

        int count = articleService.selectLikeCount(id);

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllArticleOrderByDesc")
    public List<Article> selectAllArticleOrderByDesc(){

        List<Article> articles = articleService.selectAllArticleOrderByDesc();

        return articles;
    }


    @ResponseBody
    @GetMapping(path = "/selectArticleByRecommendPage")
    public List<Article> selectArticleByRecommendPage(@RequestParam("pageNum") int pageNum,
                                                                    @RequestParam("pageSize") int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        List<Article> articles = articleService.selectArticleByRecommend();

        return articles;

    }
    @ResponseBody
    @GetMapping(path = "/selectArticleByRecommend")
    public List<Article> selectArticleByRecommend(){
        List<Article> articles = articleService.selectArticleByRecommend();
        return articles;
    }


    @ResponseBody
    @GetMapping(path = "/updateHits")
    public String updateHits(@RequestParam("id") long id){

        articleService.updateHits(id);
        return "";
    }

    @ResponseBody
    @RequestMapping(path = "/queryArticleByCategoryName")
    public List<Article> queryArticleByCategoryName(@RequestParam("categoryName") String categoryName) {

        List<Article> articles = articleService.queryArticleByCategoryName(categoryName);

        return articles;
    }


    @ResponseBody
    @GetMapping(path = "/selectArticleByArticleIdNoComment")
    public Article selectArticleByArticleIdNoComment(@RequestParam("id") long id){

        Article article = articleService.selectArticleByArticleIdNoComment(id);
        return article;
    }

    @GetMapping(path = "/updateAllowComment")
    @ResponseBody
    @ApiOperation(value = "修改是否可以评论", notes = "修改文章是否可以评论")
    public String updateAllowComment(long id, String allow) {
        if (allow.equals("false")) {
            articleService.updateAllowCommentTo_1(id);
        } else if (allow.equals("true")) {
            articleService.updateAllowCommentTo_0(id);
        }
        String s = JSON.toJSONString("success");
        return s;
    }

    @GetMapping(path = "/updateRecommend")
    @ResponseBody
    @ApiOperation(value = "修改文章是否被推荐")
    public String updateRecommend(long id, int recommend) {
        if (recommend == 0) {
            articleService.updateRecommendTo_1(id);
        } else {
            articleService.updateRecommendTo_0(id);
        }
        String json = JSON.toJSONString("success");
        return json;
    }

    @ResponseBody
    @GetMapping(path = "/selectArticleCount")
    public int selectArticleCount(){

        int count = articleService.selectArticleCount();
        return count;
    }


    @ResponseBody
    @PostMapping(path = "/publishArticle")
    public String publishArticle(@RequestBody Article article){

        articleService.publishArticle_service(article);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/changeArticle")
    public String changeArticle(@RequestBody Article article){

        articleService.changeArticle_service(article);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllArticleByCreated")
    public Map<String,Object> selectAllArticleByCreated(@RequestParam("pageNum") int pageNum,
                                                   @RequestParam("pageSize") int pageSize){

        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.selectAllArticleByCreated();

        //这个pageInfo只能写在这个调用sql语句的service方法下面才有用
        PageInfo pageInfo = new PageInfo(articles);

        Map<String,Object> map = new HashMap<>();

        String s1 = JSON.toJSONString(articles);
        String s2 = JSON.toJSONString(pageInfo);

        map.put("articles",s1);
        map.put("pageInfo",s2);
        return map;
    }


    @ResponseBody
    @GetMapping(path = "/queryArticleByTitleCount")
    public int queryArticleByTitleCount(@RequestParam("title") String title){

        int total = articleService.queryArticleByTitleCount(title);

        return total;
    }

    @ResponseBody
    @GetMapping(path = "/queryArticleByTitle")
    public List<Article> queryArticleByTitle(@RequestParam("pageNum") int pageNum,
                                             @RequestParam("pageSize") int pageSize,
                                             @RequestParam("title") String title){

        PageHelper.startPage(pageNum, pageSize);
        List<Article> articles = articleService.queryArticleByTitle(title);

        return articles;
    }


    @ResponseBody
    @GetMapping(path = "/deleteArticle")
    public String deleteArticle(@RequestParam("articleid") long articleid){

        articleService.deleteArticle_service(articleid);

    return Constant.OK;
    }



    @ResponseBody
    @GetMapping(path = "/updateAllowCommentTo1")
    public String updateAllowCommentTo_1(@RequestParam("id") long id){

        articleService.updateAllowCommentTo_1(id);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/updateAllowCommentTo0")
    public String updateAllowCommentTo_0(@RequestParam("id") long id){

        articleService.updateAllowCommentTo_0(id);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/updateRecommendTo1")
    public String updateRecommendTo_1(@RequestParam("id") long id){

        articleService.updateRecommendTo_1(id);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/updateRecommendTo0")
    public String updateRecommendTo_0(@RequestParam("id") long id){

        articleService.updateRecommendTo_0(id);

        return Constant.OK;
    }




}
