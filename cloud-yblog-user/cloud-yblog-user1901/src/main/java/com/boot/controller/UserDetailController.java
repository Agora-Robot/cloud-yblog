package com.boot.controller;

import com.boot.constant.Constant;
import com.boot.data.CommonResult;
import com.boot.pojo.UserDetail;
import com.boot.service.UserDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/feign/userdetail")
@Api("用户详情Api")
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;


    @ResponseBody
    @GetMapping(path = "/selectUserDetailByUserName")
    public UserDetail selectUserDetailByUserName(@RequestParam("name") String name){

        UserDetail userDetail = userDetailService.selectUserDetailByUserName(name);
        return userDetail;
    }

    @ResponseBody
    @PostMapping(path = "/updateUserDetail")
    public String updateUserDetail(@RequestBody UserDetail userDetail){

        userDetailService.updateUserDetail(userDetail);

        return Constant.OK;
    }

}
