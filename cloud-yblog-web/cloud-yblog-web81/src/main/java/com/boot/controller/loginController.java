package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.constant.Constant;
import com.boot.data.ResponseData.ResponseJSON;
import com.boot.feign.user.UserDetailFeign;
import com.boot.pojo.UserDetail;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 游政杰
 * 2021/8/4
 */
@Controller
@Api("登录 web api")
public class loginController {

    @Autowired
    private UserDetailFeign userDetailFeign;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(path = "/loginPage")
    public String toLoginPage(Model model, HttpServletRequest request) {

        return "comm/login";
    }

    @RequestMapping(path = "/LoginfailPage")
    public String failPage(Model model) {

        return "comm/login";
    }


    @RequestMapping(path = "/login")
    public void login(String username, String password, String code, HttpServletResponse response, HttpServletRequest request) throws IOException {


        response.sendRedirect("/");
    }

    @RequestMapping(path = "/check")
    @ResponseBody
    public String checkUsername(String username) {
        UserDetail userDetail = userDetailFeign.selectUserDetailByUserName(username);
        if (userDetail != null) { //成功
            ResponseJSON responseJSON = new ResponseJSON();
            responseJSON.setData(userDetail.getIcon()); //这个数据我传的是头像
            responseJSON.setResult(Constant.SUCCESS);
            String json = JSON.toJSONString(responseJSON);
            return json;
        } else {        //失败
            ResponseJSON responseJSON = new ResponseJSON();
            responseJSON.setResult(Constant.ERROR);
            String json = JSON.toJSONString(responseJSON);
            return json;
        }

    }

    //判断当前用户是否是通过rememberme登录,对于敏感操作就需要再次确认
    public boolean isRemembermeUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null){
            return false;
        }
        //判断当前用户是否是通过rememberme登录，是返回true,否返回false
        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }




}
