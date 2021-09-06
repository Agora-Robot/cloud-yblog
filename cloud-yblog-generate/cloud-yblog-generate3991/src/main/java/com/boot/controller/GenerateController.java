package com.boot.controller;

import com.boot.pojo.Code;
import com.boot.service.GenerateModelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/generate")
@Api("自动生成代码Api")
public class GenerateController {

    @Autowired
    private GenerateModelService generateModelService;

    @PostMapping(path = "/autoGenerate")
    @ResponseBody
    public String autoGenerate(@RequestBody Code code){

        boolean res = generateModelService.generate(code);

        if(res){

            return "生成实体类成功";

        }else {

            return "生成实体类失败";
        }

    }




}
