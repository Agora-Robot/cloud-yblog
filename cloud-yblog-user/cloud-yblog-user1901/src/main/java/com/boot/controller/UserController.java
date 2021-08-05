package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.data.CommonResult;
import com.boot.pojo.User;
import com.boot.service.RegisterService;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/feign/user")
@Api("用户Api")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private RegisterService registerService;

  @GetMapping(path = "/selectPasswordByuserName")
  public String selectPasswordByuserName(@RequestParam("name") String name) {

    String psd = userService.selectPasswordByuserName(name);
    return psd;
  }


  @ResponseBody
  @PostMapping(path = "/register")
  public String register(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("email") String email) {

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);

    registerService.register(user);

    return "success";
  }
}
