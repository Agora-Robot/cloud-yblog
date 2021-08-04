package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.pojo.Link;
import com.boot.service.LinkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "友链Api")
@Controller
@RequestMapping(path = "/feign/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ResponseBody
    @GetMapping(path = "/selectAllLink")
    public List<Link> selectAllLink(){

        List<Link> links = linkService.selectAllLink();

        return links;
    }

}
