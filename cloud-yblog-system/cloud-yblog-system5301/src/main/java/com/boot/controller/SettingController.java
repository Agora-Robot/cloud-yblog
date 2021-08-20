package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.pojo.Setting;
import com.boot.service.SettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/feign/setting")
@Api("设置Api")
public class SettingController {

  @Autowired private SettingService settingService;

  @ResponseBody
  @GetMapping(path = "/selectUserSetting")
  public Setting selectUserSetting(@RequestParam(value = "name", required = true) String name) {

    Setting setting = settingService.selectUserSetting(name);

    return setting;
  }

  @ResponseBody
  @PostMapping(path = "/addSettingByUser")
  public String addSettingByUser(@RequestBody Setting setting) {

    settingService.addSettingByUser(setting);


//    int i=10/0; //模拟异常，测试分布式事务


    return "success";
  }

  @ResponseBody
  @PostMapping(path = "/changeSettingByUser")
  public String changeSettingByUser(@RequestBody Setting setting) {

    settingService.changeSettingByUser(setting);

    return "success";
  }





}
