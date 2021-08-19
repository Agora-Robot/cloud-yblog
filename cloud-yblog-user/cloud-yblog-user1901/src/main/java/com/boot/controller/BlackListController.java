package com.boot.controller;


import com.boot.constant.Constant;
import com.boot.pojo.BlackList;
import com.boot.service.BlackListService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/feign/blacklist")
@Api("黑名单Api")
public class BlackListController {

    @Autowired
    private BlackListService blackListService;

    @ResponseBody
    @GetMapping(path = "/selectBlackList")
    public List<BlackList> selectBlackList(@RequestParam(value = "page") int page,
                                           @RequestParam(value = "limit") int limit){

        PageHelper.startPage(page, limit);
        List<BlackList> blackLists = blackListService.selectBlackList();

        return blackLists;
    }


    @ResponseBody
    @GetMapping(path = "/selectBlackCount")
    public int selectBlackCount(){

        int count = blackListService.selectBlackCount();

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/deleteBlackListByIp")
    public String deleteBlackListByIp(@RequestParam("ip") String ip){

        blackListService.deleteBlackListByIp(ip);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/addBlackList")
    public String addBlackList(@RequestBody BlackList blackList){

        blackListService.addBlackList(blackList);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/updateBlackIp")
    public String updateBlackIp(@RequestParam("oldIp") String oldIp,
                                @RequestParam("newIp") String newIp){

        blackListService.updateBlackIp(oldIp,newIp);

        return Constant.OK;
    }



}
