package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.data.ResponseData.layuiData;
import com.boot.pojo.LoginLog;
import com.boot.pojo.OperationLog;
import com.boot.service.LoginLogService;
import com.boot.service.OperationService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 游政杰
 */
@Controller
@RequestMapping(path = "/feign/log")
@Api("日志Api")
public class logController {

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private OperationService operationService;

    @ResponseBody
    @RequestMapping(path = "/log/loginlog")
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

    @ResponseBody
    @RequestMapping(path = "/log/operationLog")
    public String operationLogData(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "limit",defaultValue = "10") int limit){

        layuiData<OperationLog> data = new layuiData<>();

        PageHelper.startPage(page, limit);
        List<OperationLog> OperationLogs = operationService.selectAllOperationLog();

        int count = operationService.selectOperationCount();

        data.setCode(0);
        data.setMsg("");
        data.setData(OperationLogs);
        data.setCount(count);

        return JSON.toJSONString(data);
    }




}
