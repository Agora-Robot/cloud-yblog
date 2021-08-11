package com.boot.controller;

import com.boot.pojo.OperationLog;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/operationlog")
@Api("操作日志Api")
public class OperationController {


    @ResponseBody
    @PostMapping(path = "/insertOperationLog")
    public String insertOperationLog(@RequestBody OperationLog operationLog){



    }







}
