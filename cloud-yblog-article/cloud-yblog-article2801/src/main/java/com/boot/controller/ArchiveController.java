package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.pojo.*;
import com.boot.service.ArchiveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/** @author 游政杰 */
@Api(value = "文章归档Api")
@Controller
@RequestMapping(path = "/feign/archive")
public class ArchiveController {

  @Autowired
  private ArchiveService archiveService;



  @ResponseBody
  @GetMapping(path = "/selectAllArchiveGroup")
  public List<Archive> selectAllArchiveGroup(){

    List<Archive> archives = archiveService.selectAllArchiveGroup();

    return archives;
  }


  @ResponseBody
  @GetMapping(path = "/selectArticleByarchiveTime")
  public List<Article> selectArticleByarchiveTime(@RequestParam("date") String date) {

    List<Article> articles = archiveService.selectArticleByarchiveTime(date);

    return articles;
  }

}
