package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.pojo.UserDetail;
import com.boot.service.UserDetailService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/userdetail")
@Api("用户详情Api")
public class UserDetailController {

    private UserDetailService userDetailService;


    @ResponseBody
    @GetMapping(path = "/selectUserDetailByUserName")
    public UserDetail selectUserDetailByUserName(@RequestParam("name") String name){
        UserDetail userDetail = userDetailService.selectUserDetailByUserName(name);
        return userDetail;
    }


}
