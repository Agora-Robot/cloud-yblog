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

    @ResponseBody
    @PostMapping(path = "/feign/user/updateEmail")
    public String updateEmail(@RequestParam("email") String email,
                              @RequestParam("name") String name);

    @ResponseBody
    @PostMapping(path = "/feign/user/updatePassword")
    public String updatePassword(@RequestParam("name") String name,
                                 @RequestParam("password") String password);

    @ResponseBody
    @GetMapping(path = "/feign/user/updateValidTo1")
    public String updateValidTo_1(@RequestParam("name") String name);

    @ResponseBody
    @GetMapping(path = "/feign/user/updateValidTo0")
    public String updateValidTo_0(@RequestParam("name") String name);

}
