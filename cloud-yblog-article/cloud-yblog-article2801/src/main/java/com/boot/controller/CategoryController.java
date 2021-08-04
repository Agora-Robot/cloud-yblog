package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.pojo.*;
import com.boot.service.ArticleService;
import com.boot.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/** @author 游政杰  */
@Controller
@Api("分类Api")
@RequestMapping(path = "/feign/category")
public class CategoryController {

  @Autowired private ArticleService articleService;

  @Autowired private CategoryService categoryService;

  @ResponseBody
  @GetMapping(path = "/selectCategoryName")
  public List<String> selectCategoryName(){

    List<String> categoryName = categoryService.selectCategoryName();

    return categoryName;
  }


  @ResponseBody
  @RequestMapping(path = "/queryArticleByCategoryName")
  public List<Article> queryArticleByCategoryName(@RequestParam("categoryName") String categoryName) {

    List<Article> articles = articleService.queryArticleByCategoryName(categoryName);

    return articles;
  }
}
