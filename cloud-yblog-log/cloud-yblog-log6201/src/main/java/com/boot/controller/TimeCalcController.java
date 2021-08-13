package com.boot.controller;

import com.boot.pojo.TimeCalc;
import com.boot.service.TimeCalcService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/timecalc")
@Api("耗时操作日志Api")
public class TimeCalcController {

    @Autowired
    private TimeCalcService timeCalcService;

    @ResponseBody
    @PostMapping(path = "/insertTimeCalc")
    public String insertTimeCalc(@RequestBody TimeCalc timeCalc){

        timeCalcService.insertTimeCalc(timeCalc);

        return "success";
    }


}
