package com.boot.feign.user;

import com.boot.data.CommonResult;
import com.boot.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
@Component
//@FeignClient(value = "cloud-yblog-user",fallback = UserFeignImpl.class)
@FeignClient(value = "cloud-yblog-user")
public interface UserFeign {

    @GetMapping(path = "/feign/user/selectPasswordByuserName")
    @ResponseBody
    public String selectPasswordByuserName(@RequestParam("name") String name);

//    @ResponseBody
//    @PostMapping(path = "/feign/user/register")
//    public String register(@RequestParam("username") String username,
//                           @RequestParam("password") String password,
//                           @RequestParam("email") String email);

    @ResponseBody
    @GetMapping(path = "/feign/user/selectUseridByUserName")
    public int selectUseridByUserName(@RequestParam("username") String username);



}
