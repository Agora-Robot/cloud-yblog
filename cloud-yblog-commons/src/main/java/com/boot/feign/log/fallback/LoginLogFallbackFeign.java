package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.LoginLogFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//***实现一部分接口需要自定义fallback一部分接口不需要自定义fallback，起到一个分离的作用
@FeignClient(value = "cloud-yblog-log",fallback = LoginLogFallbackFeignImpl.class)
@Component
public interface LoginLogFallbackFeign {




}
