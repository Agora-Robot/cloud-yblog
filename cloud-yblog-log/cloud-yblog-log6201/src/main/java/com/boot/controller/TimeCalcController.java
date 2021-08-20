package com.boot.controller;

import com.boot.pojo.TimeCalc;
import com.boot.service.TimeCalcService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @GetMapping(path = "/selectAllTimeCalc")
    public List<TimeCalc> selectAllTimeCalc(@RequestParam("page") int page,
                                            @RequestParam("limit") int limit){

        PageHelper.startPage(page, limit);
        List<TimeCalc> timeCalcs = timeCalcService.selectAllTimeCalc();

        return timeCalcs;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllCount")
    public int selectAllCount(){

        int count = timeCalcService.selectAllCount();

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllTimeCalcByUri")
    public List<TimeCalc> selectAllTimeCalcByUri(@RequestParam("page") int page,
                                                 @RequestParam("limit") int limit,
                                                 @RequestParam("uri") String uri){

        PageHelper.startPage(page, limit);
        List<TimeCalc> timeCalcs = timeCalcService.selectAllTimeCalcByUri(uri);

        return timeCalcs;
    }

    @ResponseBody
    @GetMapping(path = "/selectCountByUri")
    public int selectCountByUri(@RequestParam("uri") String uri){

        int count = timeCalcService.selectCountByUri(uri);

        return count;
    }

}
