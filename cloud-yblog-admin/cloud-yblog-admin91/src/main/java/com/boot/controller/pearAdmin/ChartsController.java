package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.annotation.Operation;
import com.boot.feign.article.fallback.ArticleFallbackFeign;
import com.boot.feign.article.fallback.CategoryFallbackFeign;
import com.boot.feign.article.fallback.TagFallbackFeign;
import com.boot.feign.log.fallback.VisitorFallbackFeign;
import com.boot.feign.user.fallback.UserDetailFallbackFeign;
import com.boot.pojo.Article;
import com.boot.pojo.Category;
import com.boot.pojo.Tag;
import com.boot.pojo.UserDetail;
import com.boot.utils.Commons;
import com.boot.utils.SpringSecurityUtil;
import com.boot.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 游政杰
 * @Date 2021/8/19
 */
@Controller("pearChartsController")
@RequestMapping(path = "/pear")
@CrossOrigin
public class ChartsController {

    @Autowired
    private ArticleFallbackFeign articleFallbackFeign;

    @Autowired
    private CategoryFallbackFeign categoryFallbackFeign;

    @Autowired
    private TagFallbackFeign tagFallbackFeign;

    @Autowired
    private RedisTemplate redisTemplate;

    private final String ECHARTS_DAYS = "echarts_days"; //redis存储日期的key

    private final String ECHARTS_COUNTS = "echarts_counts";//redis存储对应的访问量的key

    @Autowired
    private VisitorFallbackFeign visitorFallbackFeign;

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @Autowired
    private UserDetailFallbackFeign userDetailFallbackFeign;
    //数据图表
    @Operation("进入数据图表页面")
    @RequestMapping(path = "/toEcharts")
    public String toEcharts(Model model, HttpSession session) {

        //提供文章阅读量数据
        List<Article> articles = articleFallbackFeign.selectArticleStatistic();
        model.addAttribute("articles", articles);

        //提供分类数的数据
        List<Category> categories = categoryFallbackFeign.selectCategories_echarts();
        model.addAttribute("categories", categories);

        //提供标签数的数据
        List<Tag> tags = tagFallbackFeign.selectTags_echarts();

        model.addAttribute("tags", tags);

        //从缓存中查有没有近7天的缓存

        Object var1 =redisTemplate.opsForValue().get(ECHARTS_DAYS);
        Object var2 =redisTemplate.opsForValue().get(ECHARTS_COUNTS);

        List<String> ds = JSON.parseArray((String) var1, String.class);
        List<Integer> cs = JSON.parseArray((String) var2, Integer.class);

        if (ds == null || ds.size() < 7 || cs == null || cs.size() < 7) { //这种情况就要重新查
            List<String> days = visitorFallbackFeign.selectDaysBy7(); //维护日期
            List<Integer> counts = new ArrayList<>(); //维护访问量
            for (String day : days) {
                int count = visitorFallbackFeign.selectOneDayVisitor(day);
                counts.add(count);
            }
            model.addAttribute("days", days);
            model.addAttribute("counts", counts);
            //让集合变成json放入redis
            String d = JSON.toJSONString(days);
            String c = JSON.toJSONString(counts);
            //让缓存在晚上12点整点就失效
            Long second = TimeUtil.getSecondByCurTimeTo12Point();
            redisTemplate.opsForValue().set(ECHARTS_DAYS, d, second, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set(ECHARTS_COUNTS, c, second, TimeUnit.SECONDS);
        } else {
            //如果还有缓存（说明没有过一天），并且数据没被篡改过（都是7个数据），就执行这里的代码
            //这个时候我们只需要更新一下最后一天（也就是今天）的数据即可
            String s = ds.get(6); //获取今天的日期
            int i = visitorFallbackFeign.selectOneDayVisitor(s);
            cs.set(6,i);
            String list = JSON.toJSONString(cs); ////记得转换成json
            model.addAttribute("days", ds);
            model.addAttribute("counts", cs);
            //重新放入redis
            Long second = TimeUtil.getSecondByCurTimeTo12Point();
            redisTemplate.opsForValue().set(ECHARTS_COUNTS, list, second, TimeUnit.SECONDS);

        }

        String username = springSecurityUtil.currentUser(session);
        UserDetail userDetail = userDetailFallbackFeign.selectUserDetailByUserName(username);
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("commons", Commons.getInstance());



        return "back/newback/article/statistic_charts";
    }



}
