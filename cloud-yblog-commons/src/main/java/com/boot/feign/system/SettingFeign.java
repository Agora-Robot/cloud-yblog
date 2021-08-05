package com.boot.feign.system;

import com.boot.data.CommonResult;
import com.boot.feign.system.impl.SettingFeignImpl;
import com.boot.pojo.Setting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "cloud-yblog-system",fallback = SettingFeignImpl.class)
public interface SettingFeign {

    @ResponseBody
    @GetMapping(path = "/feign/setting/selectUserSetting")
    public Setting selectUserSetting(@RequestParam(value = "name", required = true) String name);


    @ResponseBody
    @PostMapping(path = "/feign/setting/addSettingByUser")
    public String addSettingByUser(@RequestBody Setting setting);

}
