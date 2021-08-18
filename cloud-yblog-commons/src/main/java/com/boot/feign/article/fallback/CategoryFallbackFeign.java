package com.boot.feign.article.fallback;


import com.boot.feign.article.fallback.impl.CategoryFallbackFeignImpl;
import com.boot.pojo.Article;
import com.boot.pojo.Category;
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
    @GetMapping(path = "/feign/category/selectCategoryByName")
    public Category selectCategoryByName(@RequestParam("categoryName") String categoryName);

    @ResponseBody
    @GetMapping(path = "/feign/category/selectCountByName")
    public int selectCountByName(@RequestParam("categoryName") String categoryName);

    @ResponseBody
    @GetMapping(path = "/feign/category/selectCategories")
    public List<Category> selectCategories(@RequestParam("page") int page,
                                           @RequestParam("limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/category/selectCategoryCount")
    public int selectCategoryCount();
}
