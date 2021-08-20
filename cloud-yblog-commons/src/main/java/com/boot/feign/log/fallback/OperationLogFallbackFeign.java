package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.OperationLogFallbackFeignImpl;
import com.boot.pojo.OperationLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "cloud-yblog-log",fallback = OperationLogFallbackFeignImpl.class)
@Component
public interface OperationLogFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/operationlog/selectOperationLogByLimit")
    public List<OperationLog> selectOperationLogByLimit(@RequestParam("limit")int limit);

    @ResponseBody
    @RequestMapping(path = "/feign/operationlog/operationLogData")
    public String operationLogData(@RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "limit",defaultValue = "10") int limit);


    @ResponseBody
    @GetMapping(path = "/feign/operationlog/selectAllOperationLog")
    public List<OperationLog> selectAllOperationLog(@RequestParam("page") int page,
                                                    @RequestParam("limit") int limit);

    @ResponseBody
    @GetMapping(path = "/feign/operationlog/selectOperationCount")
    public int selectOperationCount();


}
