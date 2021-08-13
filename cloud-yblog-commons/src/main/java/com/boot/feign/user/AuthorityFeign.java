package com.boot.feign.user;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
@Component
//@FeignClient(value = "cloud-yblog-user",fallback = AuthorityFeignImpl.class)
@FeignClient(value = "cloud-yblog-user")
public interface AuthorityFeign {


    @ResponseBody
    @GetMapping(path = "/feign/authority/selectAuthorityByid")
    public String selectAuthorityByid(@RequestParam("authorityid") int authorityid);


}
