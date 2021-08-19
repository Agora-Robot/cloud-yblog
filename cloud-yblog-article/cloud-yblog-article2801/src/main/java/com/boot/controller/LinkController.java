package com.boot.controller;

import com.boot.constant.Constant;
import com.boot.data.CommonResult;
import com.boot.pojo.Link;
import com.boot.service.LinkService;
import io.swagger.annotations.Api;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping(path = "/linkCount")
    public int linkCount(){

        int count = linkService.linkCount();

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/selectLinkByTitle")
    public List<Link> selectLinkByTitle(@RequestParam("title") String title){

        List<Link> links = linkService.selectLinkByTitle(title);

        return links;
    }

    @ResponseBody
    @GetMapping(path = "/selectCountByTitle")
    public int selectCountByTitle(@RequestParam("title") String title){

        int count = linkService.selectCountByTitle(title);

        return count;
    }

    @ResponseBody
    @PostMapping(path = "/insertLink")
    public String insertLink(@RequestBody Link link){

        linkService.insertLink(link);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/updateLink")
    public String updateLink(@RequestBody Link link){

        linkService.updateLink(link);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/deleteLink")
    public String deleteLink(@RequestParam("id") long id){

        linkService.deleteLink(id);

        return Constant.OK;
    }


}
