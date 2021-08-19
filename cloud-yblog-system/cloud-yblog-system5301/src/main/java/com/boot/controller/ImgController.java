package com.boot.controller;

import com.boot.constant.Constant;
import com.boot.pojo.Img;
import com.boot.service.ImgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @GetMapping(path = "/selectAllImg")
    public List<Img> selectAllImg(){
        List<Img> imgs = imgService.selectAllImg();
        return imgs;
    }

    @ResponseBody
    @PostMapping(path = "/addImgPath")
    public String addImgPath(@RequestParam("id") long id,
                             @RequestParam("big") String big,
                             @RequestParam("small") String small){

        imgService.addImgPath(id, big, small);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/selectImgByid")
    public Img selectImgByid(@RequestParam("id") long id){
        Img img = imgService.selectImgByid(id);
        return img;
    }

    @ResponseBody
    @GetMapping(path = "/deleteImgByid")
    public String deleteImgByid(@RequestParam("id") long id){
        imgService.deleteImgByid(id);
        return Constant.OK;
    }



}
