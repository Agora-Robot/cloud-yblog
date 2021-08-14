package com.boot.feign.user.fallback;


import com.boot.feign.user.fallback.impl.UserDetailFallbackFeignImpl;
import com.boot.pojo.UserDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserDetailFallbackFeignImpl.class)
public interface UserDetailFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/userdetail/selectUserDetailByUserName")
    public UserDetail selectUserDetailByUserName(@RequestParam("name") String name);



}
