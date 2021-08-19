package com.boot.feign.user.fallback;


import com.boot.feign.user.fallback.impl.BlackListFallbackFeignImpl;
import com.boot.pojo.BlackList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = BlackListFallbackFeignImpl.class)
public interface BlackListFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/blacklist/selectBlackList")
    public List<BlackList> selectBlackList(@RequestParam(value = "page") int page,
                                           @RequestParam(value = "limit") int limit);


    @ResponseBody
    @GetMapping(path = "/feign/blacklist/selectBlackCount")
    public int selectBlackCount();


}
