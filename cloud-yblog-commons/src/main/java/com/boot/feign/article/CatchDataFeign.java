package com.boot.feign.article;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Component
@FeignClient(value = "cloud-yblog-article")
public interface CatchDataFeign {


    @ResponseBody
    @GetMapping(path = "/feign/catchData/catchDataCsdn")
    public String catchData_csdn(@RequestParam("url") String url);

    @ResponseBody
    @GetMapping(path = "/feign/catchData/batchCatchArticleByModelCsdn")
    public String batchCatchArticleByModel_csdn(@RequestParam("url") String url) throws IOException;


}
