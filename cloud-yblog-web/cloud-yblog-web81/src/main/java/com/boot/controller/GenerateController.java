package com.boot.controller;


import com.boot.feign.generate.GenerateFeign;
import com.boot.pojo.Code;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Api("自动生成代码 web api")
@RequestMapping(path = "/web/generate")
public class GenerateController {

    @Autowired
    private GenerateFeign generateFeign;

    @PostMapping(path = "/autoGenerate")
    @ResponseBody
    public String autoGenerate(@RequestBody Code code){

        String res = generateFeign.autoGenerate(code);

        return res;
    }


}
