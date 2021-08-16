package com.boot.feign.system;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(value = "cloud-yblog-system")
public interface ImgFeign {




}
