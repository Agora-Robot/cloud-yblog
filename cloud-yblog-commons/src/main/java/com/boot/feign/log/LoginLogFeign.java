package com.boot.feign.log;

import com.boot.pojo.LoginLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
//@FeignClient(value = "cloud-yblog-log",fallback = LoginLogFeignImpl.class)
@FeignClient(value = "cloud-yblog-log")
@Component
public interface LoginLogFeign {

    @ResponseBody
    @PostMapping(path = "/feign/loginlog/insertLoginLog")
    public String insertLoginLog(@RequestBody LoginLog loginLog);





}
