package com.boot.controller;

import com.alibaba.fastjson.JSON;
import com.boot.data.ResponseData.layuiData;
import com.boot.pojo.Visitor;
import com.boot.service.VisitorService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 游政杰
 *
 */
@Controller
@RequestMapping(path = "/feign/visitor")
@CrossOrigin
@Api("访问Api")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;


    @ResponseBody
    @RequestMapping(path = "/visitorData")
    public String visitorData(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "limit", defaultValue = "10") int limit){


        layuiData<Visitor> visitorlayuiData = new layuiData<>();

        PageHelper.startPage(page,limit);
        List<Visitor> Visitors = visitorService.selectVisitor();

        int count = visitorService.selectVistorCount();
        visitorlayuiData.setCode(0);
        visitorlayuiData.setCount(count);
        visitorlayuiData.setMsg("");
        visitorlayuiData.setData(Visitors);

        return JSON.toJSONString(visitorlayuiData);
    }

    @ResponseBody
    @PostMapping(path = "/insertVisitor")
    public String insertVisitor(@RequestBody Visitor visitor){

        visitorService.insertVisitor(visitor);

        return "success";
    }


    @ResponseBody
    @GetMapping(path = "/selectDaysBy7")
    public List<String> selectDaysBy7(){

        List<String> days = visitorService.selectDaysBy7();
        return days;
    }


    @ResponseBody
    @GetMapping(path = "/selectOneDayVisitor")
    public int selectOneDayVisitor(@RequestParam("day") String day){

        int count = visitorService.selectOneDayVisitor(day);

        return count;
    }


    @ResponseBody
    @GetMapping(path = "/selectVisitor")
    public List<Visitor> selectVisitor(@RequestParam("page") int page,
                                @RequestParam("limit") int limit){

        PageHelper.startPage(page,limit);
        List<Visitor> visitors = visitorService.selectVisitor();


        return visitors;
    }
    @ResponseBody
    @GetMapping(path = "/selectVistorCount")
    public int selectVistorCount(){

        int count = visitorService.selectVistorCount();

        return count;
    }

}
