package com.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.constant.Constant;
import com.boot.data.CommonResult;
import com.boot.pojo.User;
import com.boot.service.RegisterService;
import com.boot.service.UserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/feign/user")
@Api("用户Api")
public class UserController {

  @Autowired private UserService userService;

  @Autowired private RegisterService registerService;

  @GetMapping(path = "/selectPasswordByuserName")
  @ResponseBody
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


  @ResponseBody
  @GetMapping(path = "/selectUseridByUserName")
  public int selectUseridByUserName(@RequestParam("username") String username){


    return userService.selectUseridByUserName(username);
  }

  @ResponseBody
  @GetMapping(path = "/selectUserInfoByuserName")
  public User selectUserInfoByuserName(@RequestParam("username") String username){

    User user = userService.selectUserInfoByuserName(username);

    return user;
  }


  @ResponseBody
  @GetMapping(path = "/userCount")
  public int userCount(){

    int count = userService.userCount();

    return count;
  }

  @ResponseBody
  @PostMapping(path = "/updateEmail")
  public String updateEmail(@RequestParam("email") String email,
                            @RequestParam("name") String name){

    userService.updateEmail(email, name);

    return Constant.OK;
  }




  @ResponseBody
  @PostMapping(path = "/updatePassword")
  public String updatePassword(@RequestParam("name") String name,
                               @RequestParam("password") String password){

    userService.updatePassword(name, password);

    return Constant.OK;
  }

  @ResponseBody
  @GetMapping(path = "/selectAllUser")
  public List<User> selectAllUser(@RequestParam("page") int page,
                                  @RequestParam("limit") int limit){

    PageHelper.startPage(page, limit);
    List<User> users = userService.selectAllUser();

    return users;
  }

  @ResponseBody
  @GetMapping(path = "/selectUserByUsernameAndEmail")
  public List<User> selectUserByUsernameAndEmail(@RequestParam("username") String username,
                                                 @RequestParam("email") String email){

    List<User> users = userService.selectUserByUsernameAndEmail(username, email);

    return users;
  }

  @ResponseBody
  @GetMapping(path = "/selectUserCountByUsernameAndEmail")
  public int selectUserCountByUsernameAndEmail(@RequestParam("username") String username,
                                               @RequestParam("email") String email){

    int count = userService.selectUserCountByUsernameAndEmail(username, email);

    return count;
  }

  @ResponseBody
  @GetMapping(path = "/updateValidTo1")
  public String updateValidTo_1(@RequestParam("name") String name){

    userService.updateValidTo_1(name);

    return Constant.OK;
  }

  @ResponseBody
  @GetMapping(path = "/updateValidTo0")
  public String updateValidTo_0(@RequestParam("name") String name){

    userService.updateValidTo_0(name);

    return Constant.OK;
  }



}
