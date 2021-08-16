package com.boot.feign.system.fallback;

import com.boot.feign.system.fallback.impl.ImgFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-system",fallback = ImgFallbackFeignImpl.class)
public interface ImgFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/img/selectImgCount")
    public int selectImgCount();


}
