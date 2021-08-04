package com.boot.controller;


import com.alibaba.fastjson.JSON;
import com.boot.annotation.Operation;
import com.boot.constant.ThemeConstant;
import com.boot.feign.article.ArticleFeign;
import com.boot.feign.article.CategoryFeign;
import com.boot.feign.article.LinkFeign;
import com.boot.feign.article.TagFeign;
import com.boot.feign.system.SettingFeign;
import com.boot.feign.user.UserDetailFeign;
import com.boot.pojo.*;
import com.boot.utils.Commons;
import com.boot.utils.CssUtil;
import com.boot.utils.SpringSecurityUtil;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 游政杰
 */
@Controller
@Api("客户端分类 web api")
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private SpringSecurityUtil securityUtil;

    @Autowired
    private UserDetailFeign userDetailFeign;

    @Autowired
    private LinkFeign linkFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ArticleFeign articleFeign;

    @Autowired
    private CssUtil cssUtil;

    private final int type = 1;

    @Autowired
    private TagFeign tagFeign;

    @Autowired
    private SettingFeign settingFeign;

    @Autowired
    private CategoryFeign categoryFeign;


    // 前10排行
    private static final List<Article> ArticleOrder_10(List<Article> articleList) {
        List<Article> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(articleList.get(i));
        }
        return list;
    }

    private void setting(HttpSession session, ModelAndView modelAndView) {
        SecurityContextImpl securityContext =
                (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContext != null) {
            String name = securityUtil.currentUser(session);
            Setting setting = settingFeign.selectUserSetting(name);
            modelAndView.addObject("setting", setting);
        } else {
            modelAndView.addObject("setting", null);
        }
    }


    @Operation("进入分类展示页面")
    @RequestMapping(path = "/list")
    public ModelAndView toCategoryList(HttpSession session){

        ModelAndView modelAndView = new ModelAndView();

        this.setting(session, modelAndView);

        // 跳转不同页面主题判断
        if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { // calm主题
            modelAndView.setViewName("client/category2"); // 跳转页面
            List<Tag> tags = tagFeign.selectTagsByLimit8();
            modelAndView.addObject("tags", tags);
        } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { // 默认主题
//            modelAndView.setViewName("client/index"); // 跳转页面   *****  主题1 ，暂不实现
        }

        List<String> categoryName = categoryFeign.selectCategoryName();
        modelAndView.addObject("categoryName",categoryName);

        List<Article> articles = categoryFeign.queryArticleByCategoryName(categoryName.get(0));
        modelAndView.addObject("categoryArticles",articles); //查询第一个分类文章并传给前端展示



        modelAndView.addObject("cssUtil", cssUtil);

        List<Article> as = (List<Article>) redisTemplate.opsForValue().get("articleOrders10");
        if (as == null) {
            List<Article> articleOrders = ArticleOrder_10(articleFeign.selectAllArticleOrderByDesc());
            redisTemplate.opsForValue().set("articleOrders10", articleOrders, 60 * 1, TimeUnit.SECONDS);
            modelAndView.addObject("articleOrders", articleOrders);
        } else {
            modelAndView.addObject("articleOrders", as);
        }

        /** xxx个人博客标题 */
        SecurityContextImpl securityContext =
                (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (securityContext != null) {
            String name = securityUtil.currentUser(session);
            if (name != null && !name.equals("")) {
                UserDetail userDetail = userDetailFeign.selectUserDetailByUserName(name);
                modelAndView.addObject("userDetail", userDetail);
            }
        } else {
            UserDetail userDetail = null;
            modelAndView.addObject("userDetail", userDetail);
        }

        // 推荐文章
        List<Article> recommends = articleFeign.selectArticleByRecommendPage(1,5);
        modelAndView.addObject("recommends", recommends);

        // 友链
        List<Link> links = linkFeign.selectAllLink();
        modelAndView.addObject("links", links);
        modelAndView.addObject("commons", Commons.getInstance());

        return modelAndView;

    }

    @ResponseBody
    @RequestMapping(path = "/data")
    public String CategoryData(String categoryName){

        List<Article> articles = categoryFeign.queryArticleByCategoryName(categoryName);

        String jsonString = JSON.toJSONString(articles);

        return jsonString;
    }



}
