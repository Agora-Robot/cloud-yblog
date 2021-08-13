package com.boot.feign.user.fallback;

import com.boot.feign.user.fallback.impl.UserFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserFallbackFeignImpl.class)
public interface UserFallbackFeign {



}
