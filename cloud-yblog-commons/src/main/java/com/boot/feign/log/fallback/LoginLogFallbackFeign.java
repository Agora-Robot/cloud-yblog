package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.LoginLogFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//***实现一部分接口需要自定义fallback一部分接口不需要自定义fallback，起到一个分离的作用
@FeignClient(value = "cloud-yblog-log",fallback = LoginLogFallbackFeignImpl.class)
@Component
public interface LoginLogFallbackFeign {

    @ResponseBody
    @RequestMapping(path = "/feign/loginlog/loginLogData")
    public String loginLogData(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "limit", defaultValue = "10") int limit);



}
