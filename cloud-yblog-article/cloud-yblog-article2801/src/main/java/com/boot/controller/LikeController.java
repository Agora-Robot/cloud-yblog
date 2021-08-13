package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.constant.Constant;
import com.boot.data.ResponseData.ResponseJSON;
import com.boot.pojo.Like;
import com.boot.service.ArticleService;
import com.boot.service.LikeService;
import com.boot.utils.SpringSecurityUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/feign/like")
@Api("喜欢功能Api")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SpringSecurityUtil springSecurityUtil;


    @ResponseBody
    @GetMapping(path = "/selectLikeExsit")
    public String selectLikeExsit(@RequestParam("username") String username,
                               @RequestParam("articleid") long articleid){

    return likeService.selectLikeExsit(username, articleid);
    }





    @RequestMapping(path = "/art")
    @ResponseBody
    public String likeArticle(Like like, HttpSession session) {
        ResponseJSON json = new ResponseJSON();
        String name = springSecurityUtil.currentUser(session);
        like.setUsername(name);
        System.out.println(like);
        try {
            boolean flag = likeService.likeArticle(like);
            if (flag) { //如果点赞成功
                json.setResult(Constant.SUCCESS);
                //点赞成功就把最新的点赞量给前端
                int count = articleService.selectLikeCount(like.getArticle_id());
                json.setData(count+"");
            } else { //如果点赞失败
                json.setResult(Constant.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //如果异常了，也就是点赞失败了
            json.setResult(Constant.ERROR);
        }

        return JSON.toJSONString(json);
    }

}
