package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.LogFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//***所有log模块中需要自定义fallback的feign接口放到这里，实现一部分接口需要自定义fallback
// 一部分接口不需要自定义fallback，起到一个分离的作用
@FeignClient(value = "cloud-yblog-log",fallback = LogFallbackFeignImpl.class)
@Component
public interface LogFallbackFeign {




}
