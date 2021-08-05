package com.boot.feign.user;

import com.boot.data.CommonResult;
import com.boot.feign.user.impl.UserFeignImpl;
import com.boot.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserFeignImpl.class)
public interface UserFeign {

    @GetMapping(path = "/feign/user/selectPasswordByuserName")
    @ResponseBody
    public String selectPasswordByuserName(@RequestParam("name") String name);

    @ResponseBody
    @PostMapping(path = "/feign/user/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email);



}
