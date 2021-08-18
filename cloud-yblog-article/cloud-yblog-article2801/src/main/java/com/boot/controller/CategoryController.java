package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.constant.Constant;
import com.boot.pojo.*;
import com.boot.service.ArticleService;
import com.boot.service.CategoryService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
  @GetMapping(path = "/selectCategoryByName")
  public Category selectCategoryByName(@RequestParam("categoryName") String categoryName){

    Category category = categoryService.selectCategoryByName(categoryName);
    return category;
  }

  @ResponseBody
  @GetMapping(path = "/selectCountByName")
  public int selectCountByName(@RequestParam("categoryName") String categoryName){

    int count = categoryService.selectCountByName(categoryName);

    return count;
  }

  @ResponseBody
  @GetMapping(path = "/selectCategories")
  public List<Category> selectCategories(@RequestParam("page") int page,
                                         @RequestParam("limit") int limit){

    PageHelper.startPage(page, limit);
    List<Category> categories = categoryService.selectCategories();

    return categories;
  }

  @ResponseBody
  @GetMapping(path = "/selectCategoryCount")
  public int selectCategoryCount(){

    int count = categoryService.selectCategoryCount();

    return count;
  }


  @ResponseBody
  @PostMapping(path = "/addCategory")
  public String addCategory(@RequestBody Category category){

    categoryService.addCategory(category);

    return Constant.OK;
  }

  @ResponseBody
  @GetMapping(path = "/updateCategory")
  public String updateCategory(@RequestParam("oldName") String oldName,
                               @RequestParam("newName") String newName){

    categoryService.updateCategory(oldName, newName);

    return Constant.OK;
  }

  @ResponseBody
  @GetMapping(path = "/deleteCategory")
  public String deleteCategory(@RequestParam("n") String n,
                               @RequestParam("categoryName") String categoryName){

    categoryService.deleteCategory_service(n, categoryName);

    return Constant.OK;
  }



}
