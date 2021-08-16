package com.boot.feign.log;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "cloud-yblog-log")
@Component
public interface InterceptorFeign {
}
