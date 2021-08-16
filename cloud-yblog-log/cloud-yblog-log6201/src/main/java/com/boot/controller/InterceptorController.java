package com.boot.controller;


import com.boot.pojo.Intercept;
import com.boot.service.InterceptService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/feign/interceptor")
@Api("拦截日志Api")
public class InterceptorController {

    @Autowired
    private InterceptService interceptService;


    @ResponseBody
    @GetMapping(path = "/selectIntercepts")
    public List<Intercept> selectIntercepts(@RequestParam(value = "page") int page,
                                            @RequestParam(value = "limit") int limit){

        PageHelper.startPage(page,limit);
        List<Intercept> intercepts = interceptService.selectIntercepts();
        return intercepts;
    }

    @ResponseBody
    @GetMapping(path = "/selectInterceptCount")
    public int selectInterceptCount(){

        int count = interceptService.selectInterceptCount();
        return count;
    }





}
