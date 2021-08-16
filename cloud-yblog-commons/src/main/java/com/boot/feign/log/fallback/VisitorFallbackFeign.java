package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.VisitorFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "cloud-yblog-log",fallback = VisitorFallbackFeignImpl.class)
@Component
public interface VisitorFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/visitor/selectDaysBy7")
    public List<String> selectDaysBy7();

    @ResponseBody
    @GetMapping(path = "/feign/visitor/selectOneDayVisitor")
    public int selectOneDayVisitor(@RequestParam("day") String day);


}
