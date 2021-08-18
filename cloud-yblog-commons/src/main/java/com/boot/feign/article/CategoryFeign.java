package com.boot.feign.article;

import com.boot.pojo.Article;
import com.boot.pojo.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-article")
public interface CategoryFeign {

    @ResponseBody
    @PostMapping(path = "/feign/category/addCategory")
    public String addCategory(@RequestBody Category category);

    @ResponseBody
    @GetMapping(path = "/feign/category/updateCategory")
    public String updateCategory(@RequestParam("oldName") String oldName,
                                 @RequestParam("newName") String newName);

    @ResponseBody
    @GetMapping(path = "/feign/category/deleteCategory")
    public String deleteCategory(@RequestParam("n") String n,
                                 @RequestParam("categoryName") String categoryName);
}
