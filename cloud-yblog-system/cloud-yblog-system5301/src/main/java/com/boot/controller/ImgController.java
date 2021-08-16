package com.boot.controller;

import com.boot.service.ImgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/img")
@Api("附件Api")
public class ImgController {

    @Autowired
    private ImgService imgService;

    @ResponseBody
    @GetMapping(path = "/selectImgCount")
    public int selectImgCount(){

        int count = imgService.selectImgCount();

        return count;
    }


}
