package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.data.ResponseData.layuiData;
import com.boot.pojo.LoginLog;
import com.boot.service.LoginLogService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/feign/loginlog")
@Api("登入日志Api")
public class LoginLogController {

    @Autowired
    private LoginLogService loginLogService;

    @ResponseBody
    @PostMapping(path = "/insertLoginLog")
    public String insertLoginLog(@RequestBody LoginLog loginLog){

        loginLogService.insertLoginLog(loginLog);
        return "";
    }

    @ResponseBody
    @RequestMapping(path = "/loginLogData")
    public String loginLogData(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "limit", defaultValue = "10") int limit){
        layuiData<LoginLog> data = new layuiData<>();

        PageHelper.startPage(page,limit);
        List<LoginLog> LoginLogs = loginLogService.selectLoginLogAll();

        int count = loginLogService.loginLogCount();

        data.setCode(0);
        data.setMsg("");
        data.setData(LoginLogs);
        data.setCount(count);
        return JSON.toJSONString(data);
    }

}
