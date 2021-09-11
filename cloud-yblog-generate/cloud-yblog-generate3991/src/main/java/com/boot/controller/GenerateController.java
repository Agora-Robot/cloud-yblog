package com.boot.controller;

import com.boot.pojo.Code;
import com.boot.service.GenerateModelService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/generate")
@Api("自动生成代码Api")
@Slf4j
public class GenerateController {

    @Autowired
    private GenerateModelService generateModelService;

  /**
   * 测试接口：用PostMan发送post请求给下面这个接口 测试数据：
   * { "className":"person", "attributes":[ "long,id",
   * "String,content", "Boolean,allowComment", "String,thumbnail", "Integer,likes" ] }
   */
  @PostMapping(path = "/autoGenerate")
  @ResponseBody
  public String autoGenerate(@RequestBody Code code) {

      long start = System.currentTimeMillis();
        boolean res = generateModelService.generate(code);

        if(res){
            long end = System.currentTimeMillis();
            log.info("生成代码耗时："+(end-start)+"ms");

            return "生成实体类成功";

        }else {

            return "生成实体类失败";
        }

    }




}
