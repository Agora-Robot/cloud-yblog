package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/feign/user")
@Api("用户Api")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(path = "/selectPasswordByuserName")
    public String selectPasswordByuserName(@RequestParam("name") String name){

        String psd = userService.selectPasswordByuserName(name);
        return psd;
    }



}
