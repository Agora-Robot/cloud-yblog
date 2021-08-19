package com.boot.controller;


import com.boot.constant.Constant;
import com.boot.service.CatchDataService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Api(value = "爬取文章Api")
@Controller
@RequestMapping(path = "/feign/catchData")
public class CatchDataController {

    @Autowired
    private CatchDataService catchDataService;

    @ResponseBody
    @GetMapping(path = "/catchDataCsdn")
    public String catchData_csdn(@RequestParam("url") String url){


        catchDataService.catchData_csdn(url);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/batchCatchArticleByModelCsdn")
    public String batchCatchArticleByModel_csdn(@RequestParam("url") String url) throws IOException {


        catchDataService.batchCatchArticleByModel_csdn(url);

        return Constant.OK;
    }


}
