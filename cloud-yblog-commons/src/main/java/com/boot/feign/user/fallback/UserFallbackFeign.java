package com.boot.feign.user.fallback;

import com.boot.feign.user.fallback.impl.UserFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserFallbackFeignImpl.class)
public interface UserFallbackFeign {


    @ResponseBody
    @PostMapping(path = "/feign/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email);


}
