package com.boot.feign.system.fallback;

import com.boot.feign.system.fallback.impl.SettingFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

//***所有log模块中需要自定义fallback的feign接口放到这里，实现一部分接口需要自定义fallback
// 一部分接口不需要自定义fallback，起到一个分离的作用
@Component
@FeignClient(value = "cloud-yblog-system",fallback = SettingFallbackFeignImpl.class)
public interface SettingFallbackFeign {



}
