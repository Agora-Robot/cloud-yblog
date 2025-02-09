package com.boot.feign.user.fallback;


import com.boot.feign.user.fallback.impl.UserAuthorityFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = UserAuthorityFallbackFeignImpl.class)
public interface UserAuthorityFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/userauthority/selectAuthorityID")
    public int selectAuthorityID(@RequestParam("userid") long userid);


}
