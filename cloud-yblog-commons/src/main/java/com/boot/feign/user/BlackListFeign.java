package com.boot.feign.user;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;


@Component
@FeignClient(value = "cloud-yblog-user")
public interface BlackListFeign {





}
