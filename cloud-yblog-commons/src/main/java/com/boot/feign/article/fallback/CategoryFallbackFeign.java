package com.boot.feign.article.fallback;


import com.boot.feign.article.fallback.impl.CategoryFallbackFeignImpl;
import com.boot.pojo.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = CategoryFallbackFeignImpl.class)
public interface CategoryFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/category/selectCategoryName")
    public List<String> selectCategoryName();


    @ResponseBody
    @RequestMapping(path = "/feign/category/queryArticleByCategoryName")
    public List<Article> queryArticleByCategoryName(@RequestParam("categoryName")String categoryName);



}
