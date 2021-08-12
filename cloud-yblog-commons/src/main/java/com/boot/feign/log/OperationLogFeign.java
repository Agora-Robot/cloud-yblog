package com.boot.feign.log;

import com.boot.feign.log.impl.LoginLogFeignImpl;
import com.boot.feign.log.impl.OperationLogFeignImpl;
import com.boot.pojo.OperationLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "cloud-yblog-log",fallback = OperationLogFeignImpl.class)
@Component
public interface OperationLogFeign {

    @ResponseBody
    @PostMapping(path = "/feign/operationlog/insertOperationLog")
    public String insertOperationLog(@RequestBody OperationLog operationLog);


}
