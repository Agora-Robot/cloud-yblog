package com.boot.controller;

import com.boot.pojo.LoginLog;
import com.boot.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
