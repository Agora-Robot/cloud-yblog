package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.pojo.Setting;
import com.boot.service.SettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/setting")
@Api("设置Api")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @ResponseBody
    @GetMapping(path = "/selectUserSetting")
    public Setting selectUserSetting(@RequestParam(value = "name",required = true) String name){

        Setting setting = settingService.selectUserSetting(name);

        return setting;
    }





}
