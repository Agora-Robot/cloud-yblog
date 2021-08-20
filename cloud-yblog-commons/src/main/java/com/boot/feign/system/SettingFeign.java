package com.boot.feign.system;

import com.boot.data.CommonResult;
import com.boot.pojo.Setting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
/**
 * ？？？？？？？？？？？？？？？？
 * 实测：如果feign接口写了fallback方法，即使在fallback方法里面抛出Runtime异常也不能让全局事务回滚========
 * ？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
 * 所以，暂时把fallback方法取消
 */
//@FeignClient(value = "cloud-yblog-system",fallback = SettingFeignImpl.class)
@FeignClient(value = "cloud-yblog-system")
public interface SettingFeign {


    @ResponseBody
    @PostMapping(path = "/feign/setting/addSettingByUser")
    public String addSettingByUser(@RequestBody Setting setting);

    @ResponseBody
    @PostMapping(path = "/feign/setting/changeSettingByUser")
    public String changeSettingByUser(@RequestBody Setting setting);

}
