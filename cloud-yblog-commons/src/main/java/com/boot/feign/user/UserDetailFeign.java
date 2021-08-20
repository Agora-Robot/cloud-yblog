package com.boot.feign.user;

import com.boot.data.CommonResult;
import com.boot.pojo.UserDetail;
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
//@FeignClient(value = "cloud-yblog-user",fallback = UserDetailFeignImpl.class)
@FeignClient(value = "cloud-yblog-user")
public interface UserDetailFeign {

    @ResponseBody
    @PostMapping(path = "/feign/userdetail/updateUserDetail")
    public String updateUserDetail(@RequestBody UserDetail userDetail);


}
