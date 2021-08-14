package com.boot.feign.user.fallback;


import com.boot.feign.user.fallback.impl.AuthorityFallbackFeignImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "cloud-yblog-user",fallback = AuthorityFallbackFeignImpl.class)
public interface AuthorityFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/authority/selectAuthorityByid")
    public String selectAuthorityByid(@RequestParam("authorityid") int authorityid);


}
