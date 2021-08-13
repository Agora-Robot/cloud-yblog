package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boot.annotation.Visitor;
import com.boot.constant.ThemeConstant;
import com.boot.data.CommonResult;
import com.boot.feign.article.ArticleFeign;
import com.boot.feign.article.LikeFeign;

import com.boot.feign.article.LinkFeign;
import com.boot.feign.article.TagFeign;

import com.boot.feign.article.fallback.ArticleFallbackFeign;
import com.boot.feign.system.SettingFeign;
import com.boot.feign.user.UserDetailFeign;
import com.boot.pojo.*;
import com.boot.utils.Commons;
import com.boot.utils.IpUtils;
import com.boot.utils.SpringSecurityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/** @author 游政杰 2021/8/3 12:05*/
@Controller
@Api("客户端首页 web api")
@Slf4j
public class IndexController {

  @Autowired private ArticleFeign articleFeign;

  @Autowired private SettingFeign settingFeign;

  @Autowired private LikeFeign likeFeign;

  @Autowired private TagFeign tagFeign;

  @Autowired private UserDetailFeign userDetailFeign;

  @Autowired private LinkFeign linkFeign;

  @Autowired private RedisTemplate redisTemplate;

  @Autowired private SpringSecurityUtil securityUtil;

  @Autowired
  private ArticleFallbackFeign articleFallbackFeign;


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

  // 前10排行
  private static final List<Article> ArticleOrder_10(List<Article> articleList) {
    List<Article> list = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      list.add(articleList.get(i));
    }
    return list;
  }

  private void queryUserDeail(HttpSession session, ModelAndView modelAndView) {
    SecurityContextImpl securityContext =
        (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (securityContext != null) {
      String name = securityUtil.currentUser(session);
      if (name != null && !name.equals("")) {

        UserDetail userDetailCommonResult = userDetailFeign.selectUserDetailByUserName(name);

        modelAndView.addObject("userDetail", userDetailCommonResult);
      }
    } else {
      UserDetail userDetail = null;
      modelAndView.addObject("userDetail", userDetail);
    }
  }

  @Visitor(desc = "访问首页")
  @RequestMapping(path = {"/"})
  public ModelAndView toIndex1(
      HttpSession session, HttpServletRequest request, HttpServletResponse response) {

    ModelAndView modelAndView = new ModelAndView();

    //        System.out.println("测试负载均衡==当前端口是："+port);

    // 传setting给前端
    this.setting(session, modelAndView);

    modelAndView.addObject("articleFeign", articleFeign);
    modelAndView.addObject("articleFallbackFeign", articleFallbackFeign);
    SecurityContextImpl securityContext =
        (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (securityContext != null) {
      String name = securityUtil.currentUser(session);
      if (name != null && !name.equals("")) {
        modelAndView.addObject("user", name);
      }
    } else {
      modelAndView.addObject("user", null);
    }

    // 跳转不同页面主题判断
    if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { // calm主题
      modelAndView.setViewName("client/index2"); // 跳转页面
      List<Tag> listCommonResult = tagFeign.selectTagsByLimit8();
      modelAndView.addObject("indexAc", "active");
      modelAndView.addObject("tags", listCommonResult);

    } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { // 默认主题
      modelAndView.setViewName("client/index"); // 跳转页面
    }

    Map<String,Object> map = articleFeign.selectAllArticleByPage(1, 8);

    List<Article> as = (List<Article>) redisTemplate.opsForValue().get("articleOrders10");
    if (as == null) {
      List<Article> listCommonResult = articleFeign.selectAllArticleOrderByDesc();
      List<Article> articleOrders = ArticleOrder_10(listCommonResult);
      redisTemplate.opsForValue().set("articleOrders10", articleOrders, 60 * 1, TimeUnit.SECONDS);
      modelAndView.addObject("articleOrders", articleOrders);
    } else {
      modelAndView.addObject("articleOrders", as);
    }

    /** xxx个人博客标题 */
    this.queryUserDeail(session, modelAndView);

    // 友链
    List<Link> linkResult = linkFeign.selectAllLink();
    modelAndView.addObject("links", linkResult);

    // 推荐文章
    List<Article> recommendResult = articleFeign.selectArticleByRecommendPage(1, 5);

    modelAndView.addObject("recommends", recommendResult);

    String s2 = (String) map.get("pageInfo");

    //******这里有坑，一定要用这种方式才可以转换集合，不然会出现类型转换异常，不能用JSONObject去转换
    List<Article> articles = JSON.parseArray((String) map.get("articles"), Article.class);

    PageInfo pageInfo = JSONObject.parseObject(s2, PageInfo.class);



    modelAndView.addObject("articles", articles);
    modelAndView.addObject("commons", Commons.getInstance());
    modelAndView.addObject("pageInfo", pageInfo);

    return modelAndView;
  }


  @Visitor(desc = "访问首页")
  @RequestMapping(path = {"/page/{pageNum}"})
  public ModelAndView toIndex2(@PathVariable("pageNum") int pageNum, HttpSession session, HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();

    //传setting给前端
    this.setting(session,modelAndView);

    modelAndView.addObject("articleFeign",articleFeign);
    modelAndView.addObject("articleFallbackFeign",articleFallbackFeign);
    SecurityContextImpl securityContext = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (securityContext != null) {
      String name = securityUtil.currentUser(session);
      if (name != null && !name.equals("")) {
        modelAndView.addObject("user",name);
      }
    } else {
      modelAndView.addObject("user",null);
    }

    //跳转不同页面主题判断
    if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { //calm主题
      modelAndView.setViewName("client/index2"); //跳转页面
      modelAndView.addObject("indexAc", "active");
      List<Tag> tags = tagFeign.selectTagsByLimit8();
      modelAndView.addObject("tags", tags);

    } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { //默认主题
      modelAndView.setViewName("client/index"); //跳转页面

    }

    Map<String,Object> map = articleFeign.selectAllArticleByPage(pageNum,8);

    String s2 = (String) map.get("pageInfo");

    //******这里有坑，一定要用这种方式才可以转换集合，不然会出现类型转换异常，不能用JSONObject去转换
    List<Article> articles = JSON.parseArray((String) map.get("articles"), Article.class);

    PageInfo pageInfo = JSONObject.parseObject(s2, PageInfo.class);


    List<Article> as = (List<Article>) redisTemplate.opsForValue().get("articleOrders10");
    if (as == null) {
      List<Article> articleOrders = ArticleOrder_10(articleFeign.selectAllArticleOrderByDesc());
      redisTemplate.opsForValue().set("articleOrders10", articleOrders, 60 * 1, TimeUnit.SECONDS);
      modelAndView.addObject("articleOrders", articleOrders);
    } else {
      modelAndView.addObject("articleOrders", as);
    }

    /**
     * xxx个人博客标题
     */
    this.queryUserDeail(session, modelAndView);


    //友链
    List<Link> links = linkFeign.selectAllLink();
    modelAndView.addObject("links", links);

    //推荐文章
    List<Article> recommends = articleFeign.selectArticleByRecommendPage(1,5);
    modelAndView.addObject("recommends",recommends);

    modelAndView.addObject("articles", articles);
    modelAndView.addObject("commons", Commons.getInstance());
    modelAndView.addObject("pageInfo", pageInfo);

    return modelAndView;
  }

  @Visitor(desc = "访问文章")
  @GetMapping(path = "/article/{articleId}")
  public ModelAndView toArticleDetailByID(
      @PathVariable("articleId") Integer articleId,
      HttpServletRequest request,
      HttpSession session) {
    ModelAndView modelAndView = new ModelAndView();

    // 传setting给前端
    this.setting(session, modelAndView);

    // 当某个ip在短时间内不断访问某篇文章会造成点击量+1
    // 需求：我们想让用户ip访问文章后2分钟内，再次点击这篇文章点击量不会+1，防止用户刷点击量
    String ipAddr = IpUtils.getIpAddr(request); // 1.先获取ip
    String key = "ip_" + ipAddr + "_ar_" + articleId;
    Object o = redisTemplate.opsForValue().get(key); // 2.通过ip和文章id，去查询有没有对应的值
    if (o == null) {
      // 文章点击数+1
      articleFeign.updateHits(articleId);
      redisTemplate.opsForValue().set(key, "1", 60 * 2, TimeUnit.SECONDS); // 设置2分钟的过期时间
    }

    // 传入
    modelAndView.addObject("indexAc", "active");

    boolean res = false; // 判断是否传入参数“c”
    Article article = null;

    /** xxx个人博客标题 */
    SecurityContextImpl securityContext =
        (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    if (securityContext != null) {
      String name = securityUtil.currentUser(session);
      if (name != null && !name.equals("")) {
        UserDetail userDetailCommonResult = userDetailFeign.selectUserDetailByUserName(name);
        modelAndView.addObject("name", name);
        modelAndView.addObject("userDetail", userDetailCommonResult);
      }
    } else {
      UserDetail userDetail = null;
      modelAndView.addObject("userDetail", userDetail);
    }

    // 从Redis数据库中获取指定文章id的数据，如果没有就从数据库查询，然后在放入redis中
    article = (Article) redisTemplate.opsForValue().get("articleId_" + articleId);
    if (article == null) {
      article = articleFeign.selectArticleByArticleIdNoComment(articleId); // 查文章内容（没有评论）
      redisTemplate.opsForValue().set("articleId_" + articleId, article);
    }
    String c = request.getParameter("c");
    int pageNum = 0;
    if (c == null || c.equals("")) {
      res = false;
    } else {
      try {
        pageNum = Integer.parseInt(c);
        res = true;
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
        res = false;
      }
    }
    if (res) {
      modelAndView.addObject("article", article);
      modelAndView.addObject("commons", Commons.getInstance());
      modelAndView.addObject("articleId", articleId);
      if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { // calm主题
        modelAndView.setViewName("client/articleDetails2"); // 跳转页面

      } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { // 默认主题
        modelAndView.setViewName("client/articleDetails"); // 跳转页面
      }
      return modelAndView;

    } else {
      // 友链
      List<Link> links = linkFeign.selectAllLink();
      modelAndView.addObject("links", links);

      // 推荐文章
      List<Article> recommends = articleFeign.selectArticleByRecommendPage(1, 5);
      modelAndView.addObject("recommends", recommends);

      modelAndView.addObject("article", article);
      modelAndView.addObject("commons", Commons.getInstance());
      modelAndView.addObject("articleId", articleId);

      // 跳转不同页面主题判断
      if (ThemeConstant.curTheme.equals(ThemeConstant.CALM_THEME)) { // calm主题
        modelAndView.setViewName("client/articleDetails2"); // 跳转页面
        List<Tag> tags = tagFeign.selectTagsByLimit8();
        modelAndView.addObject("tags", tags);
        List<Article> as = (List<Article>) redisTemplate.opsForValue().get("articleOrders10");
        if (as == null) {
          List<Article> articleOrders = ArticleOrder_10(articleFeign.selectAllArticleOrderByDesc());
          redisTemplate.opsForValue().set("articleOrders10", articleOrders, 60 * 1, TimeUnit.SECONDS);
          modelAndView.addObject("articleOrders", articleOrders);
        } else {
          modelAndView.addObject("articleOrders", as);
        }

      } else if (ThemeConstant.curTheme.equals(ThemeConstant.DEFAULT_THEME)) { // 默认主题
        modelAndView.setViewName("client/articleDetails"); // 跳转页面
      }

      return modelAndView;
    }
  }
}
