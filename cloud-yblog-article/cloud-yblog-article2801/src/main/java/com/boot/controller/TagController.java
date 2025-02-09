package com.boot.controller;

import com.boot.data.CommonResult;
import com.boot.pojo.Tag;
import com.boot.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/feign/tag")
@Api("标签Api")
public class TagController {

    @Autowired
    private TagService tagService;


    @ResponseBody
    @GetMapping(path = "/selectTagsByLimit8")
    public List<Tag> selectTagsByLimit8(){

        List<Tag> tags = tagService.selectTags_limit8();
        return tags;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllTag")
    public List<Tag> selectAllTag(){

        List<Tag> tags = tagService.selectAllTag();

        return tags;
    }

    @ResponseBody
    @GetMapping(path = "/selectTagCount")
    public int selectTagCount(){

        int count = tagService.selectTagCount();

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/selectTagsEcharts")
    public List<Tag> selectTags_echarts(){

        List<Tag> tags = tagService.selectTags_echarts();

        return tags;
    }



}
