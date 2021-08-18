package com.boot.feign.article;

import com.boot.data.CommonResult;
import com.boot.pojo.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
@Component
//@FeignClient(value = "cloud-yblog-article",fallback = ArticleFeignImpl.class)
@FeignClient(value = "cloud-yblog-article")
public interface ArticleFeign {


    @ResponseBody
    @PostMapping(path = "/feign/article/publishArticle")
    public String publishArticle(@RequestBody Article article);

    @ResponseBody
    @PostMapping(path = "/feign/article/changeArticle")
    public String changeArticle(@RequestBody Article article);


    @ResponseBody
    @GetMapping(path = "/feign/article/updateHits")
    public String updateHits(@RequestParam("id") long id);


    @ResponseBody
    @GetMapping(path = "/feign/article/updateAllowCommentTo1")
    public String updateAllowCommentTo_1(@RequestParam("id") long id);

    @ResponseBody
    @GetMapping(path = "/feign/article/updateAllowCommentTo0")
    public String updateAllowCommentTo_0(@RequestParam("id") long id);


    @ResponseBody
    @GetMapping(path = "/feign/article/updateRecommendTo1")
    public String updateRecommendTo_1(@RequestParam("id") long id);


    @ResponseBody
    @GetMapping(path = "/feign/article/updateRecommendTo0")
    public String updateRecommendTo_0(@RequestParam("id") long id);

    @ResponseBody
    @GetMapping(path = "/feign/article/deleteArticle")
    public String deleteArticle(@RequestParam("articleid") long articleid);


}
