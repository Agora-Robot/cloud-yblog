package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.annotation.Visitor;
import com.boot.data.ResponseData.ArticleResponseData;
import com.boot.feign.article.fallback.ArticleFallbackFeign;
import com.boot.feign.article.fallback.CategoryFallbackFeign;
import com.boot.feign.article.fallback.StatisticFallbackFeign;
import com.boot.feign.article.fallback.TagFallbackFeign;
import com.boot.feign.log.fallback.VisitorFallbackFeign;
import com.boot.feign.system.fallback.ImgFallbackFeign;
import com.boot.feign.system.fallback.SettingFallbackFeign;
import com.boot.feign.user.fallback.UserDetailFallbackFeign;
import com.boot.pojo.Article;
import com.boot.pojo.Setting;
import com.boot.pojo.Tag;
import com.boot.pojo.UserDetail;
import com.boot.utils.Commons;
import com.boot.utils.IpUtils;
import com.boot.utils.SpringSecurityUtil;
import com.boot.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 游政杰
 * 2021/8/16 1:01
 */
@Controller
@RequestMapping("/admin")
@Api(value = "后台管理控制器")
@Slf4j //slf4j日志
public class AdminController {

    private final String DEFAULT_CATEGORY = "默认分类";

    @Autowired
    private ArticleFallbackFeign articleFallbackFeign;

    @Autowired
    private StatisticFallbackFeign statisticFallbackFeign;

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CategoryFallbackFeign categoryFallbackFeign;

    @Autowired
    private TagFallbackFeign tagFallbackFeign;

    @Autowired
    private UserDetailFallbackFeign userDetailFallbackFeign;

    @Autowired
    private ImgFallbackFeign imgFallbackFeign;

    @Autowired
    private VisitorFallbackFeign visitorFallbackFeign;

    private final int type = 1;

    @Autowired
    private SettingFallbackFeign settingFallbackFeign;

    private static List<String> themes = new ArrayList<>();

    private final String ECHARTS_DAYS = "echarts_days"; //redis存储日期的key

    private final String ECHARTS_COUNTS = "echarts_counts";//redis存储对应的访问量的key

    private final String PEAR_THEME="pear";

    private final String curTheme="pear";


//    //初始化redis有关t_tag表的数据
//    @PostConstruct
//    public void initTags() {
//        List<Tag> tags = tagFallbackFeign.selectAllTag();
//
//        for (Tag tag : tags) {
//            redisTemplate.opsForValue().set("tag_" + tag.getTagName(), tag.getTagCount());
//        }
//
//    }


    @Visitor(desc = "进入后台界面")
    @GetMapping(path = "/")
    @ApiOperation(value = "去后台管理界面", notes = "以/作为路径进入")
    public String toAdmin() {


        return "back/newback/index";
    }






}