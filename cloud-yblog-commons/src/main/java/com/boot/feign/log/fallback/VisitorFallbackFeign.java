package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.VisitorFallbackFeignImpl;
import com.boot.pojo.Visitor;
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


    @ResponseBody
    @GetMapping(path = "/feign/visitor/selectVisitor")
    public List<Visitor> selectVisitor(@RequestParam("page") int page,
                                       @RequestParam("limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/visitor/selectVistorCount")
    public int selectVistorCount();


}
