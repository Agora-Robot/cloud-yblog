package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.data.ResponseData.layuiData;
import com.boot.data.ResponseData.layuiJSON;
import com.boot.feign.user.UserFeign;
import com.boot.feign.user.fallback.UserFallbackFeign;
import com.boot.pojo.User;
import com.boot.utils.SpringSecurityUtil;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author 游政杰
 */
@Controller("pearUserManagerController")
@RequestMapping(path = "/pear")
@CrossOrigin
@Slf4j
public class UserManagerController {

    @Autowired
    private UserFallbackFeign userFallbackFeign;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private SpringSecurityUtil springSecurityUtil;

    @ResponseBody
    @RequestMapping(path = "/userManagerData")
    public String userManagerData(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "limit", defaultValue = "6") int limit,
                                  @RequestParam(value = "username", defaultValue = "") String username,
                                  @RequestParam(value = "email", defaultValue = "") String email,
                                  HttpSession session) {
        if (StringUtils.isBlank(username) && StringUtils.isBlank(email)) { //这种情况查询全部
            layuiData<User> json = new layuiData<>();

            List<User> users = userFallbackFeign.selectAllUser(page, limit);
            String name = springSecurityUtil.currentUser(session);

            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(date);
            log.debug(time + "   用户名：" + name + "进入后台用户管理页面");

            int total = userFallbackFeign.userCount();

            json.setCode(0);
            json.setCount(total); //总数
            json.setMsg("");
            json.setData(users); //分页数据

            return JSON.toJSONString(json);
        } else { //查询条件

            layuiData<User> userlayuiData = new layuiData<>();

            List<User> users = userFallbackFeign.selectUserByUsernameAndEmail(username, email);

            int count = userFallbackFeign.selectUserCountByUsernameAndEmail(username, email);

            userlayuiData.setCode(0);
            userlayuiData.setMsg("");
            userlayuiData.setData(users);
            userlayuiData.setCount(count);
            return JSON.toJSONString(userlayuiData);

        }


    }


    @GetMapping(path = "/enable/Vaild")
    @ResponseBody
    public String updateVaildEnable(String name,
                                    HttpSession session) {


        layuiJSON json = new layuiJSON();

        try {

            userFeign.updateValidTo_1(name);
            json.setMsg("66");
            json.setSuccess(true);
        } catch (Exception e) {

            e.printStackTrace();
            json.setMsg("66");
            json.setSuccess(false);
        }

        return JSON.toJSONString(json);
    }

    @GetMapping(path = "/disable/Vaild")
    @ResponseBody
    public String updateVaildDisable(String name,
                                     HttpSession session) {
        layuiJSON json = new layuiJSON();

        try {

            userFeign.updateValidTo_0(name);
            json.setMsg("77");
            json.setSuccess(true);
        } catch (Exception e) {

            e.printStackTrace();
            json.setMsg("77");
            json.setSuccess(false);
        }

        return JSON.toJSONString(json);
    }

}
