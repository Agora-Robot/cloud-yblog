package com.boot.feign.log.fallback;


import com.boot.feign.log.fallback.impl.TimeCalcFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "cloud-yblog-log",fallback = TimeCalcFallbackFeignImpl.class)
@Component
public interface TimeCalcFallbackFeign {



}
